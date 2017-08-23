/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.openhab.binding.miio.internal.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.openhab.binding.miio.MiIoBindingConstants;
import org.openhab.binding.miio.internal.Message;
import org.openhab.binding.miio.internal.MiIoCommand;
import org.openhab.binding.miio.internal.MiIoCrypto;
import org.openhab.binding.miio.internal.MiIoCryptoException;
import org.openhab.binding.miio.internal.MiIoMessageListener;
import org.openhab.binding.miio.internal.MiIoSendCommand;
import org.openhab.binding.miio.internal.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * The {@link MiIoAsyncCommunication} is responsible for communications with the Mi IO devices
 *
 * The MiIoAsyncCommunication is WORK IN PROGRESS! to replace the synchronous MiIoCommunication class
 *
 * @author Marcel Verpaalen - Initial contribution
 */
public class MiIoAsyncCommunication implements XiaomiSocketListener {

    private static final int MSG_BUFFER_SIZE = 2048;
    private static final int TIMEOUT = 4000;

    private final Logger logger = LoggerFactory.getLogger(MiIoAsyncCommunication.class);

    private final String ip;
    private final byte[] token;
    private byte[] deviceId;
    private XiaomiMiIoSocket ssocket;
    private List<MiIoMessageListener> listeners = new CopyOnWriteArrayList<>();

    private AtomicInteger id = new AtomicInteger();
    private int timeDelta;
    private int timeStamp;
    JsonParser parser;

    private ConcurrentHashMap<Integer, MiIoSendCommand> commandsSend = new ConcurrentHashMap<Integer, MiIoSendCommand>();
    private ConcurrentLinkedQueue<MiIoSendCommand> concurrentLinkedQueue = new ConcurrentLinkedQueue<MiIoSendCommand>();

    public MiIoAsyncCommunication(String ip, byte[] token, byte[] did, int id) {

        this.ip = ip;
        this.token = token;
        this.deviceId = did;
        setId(id);
        parser = new JsonParser();
        ssocket = new XiaomiMiIoSocket(ip);
        ssocket.intialize();
        ssocket.registerListener(this);
    }

    protected List<MiIoMessageListener> getListeners() {
        return listeners;
    }

    /**
     * Registers a {@link XiaomiSocketListener} to be called back, when data is received.
     * If no {@link XiaomiSocket} exists, when the method is called, it is being set up.
     *
     * @param listener - {@link XiaomiSocketListener} to be called back
     */
    public synchronized void registerListener(MiIoMessageListener listener) {
        if (!getListeners().contains(listener)) {
            logger.trace("Adding socket listener {}", listener);
            getListeners().add(listener);
        }

    }

    /**
     * Unregisters a {@link XiaomiSocketListener}. If there are no listeners left,
     * the {@link XiaomiSocket} is being closed.
     *
     * @param listener - {@link XiaomiSocketListener} to be unregistered
     */
    public synchronized void unregisterListener(MiIoMessageListener listener) {
        getListeners().remove(listener);
    }

    public String sendCommand(MiIoCommand command) throws MiIoCryptoException, IOException {
        return sendCommand(command, "[]");
    }

    public String sendCommand(MiIoCommand command, String params) throws MiIoCryptoException, IOException {
        return sendCommand(command.getCommand(), params);
    }

    public String sendCommand(String command, String params)
            throws MiIoCryptoException, IOException, JsonSyntaxException {
        try {
            JsonObject fullCommand = new JsonObject();
            int cmdId = id.incrementAndGet();
            fullCommand.addProperty("id", cmdId);
            fullCommand.addProperty("method", command);
            fullCommand.add("params", parser.parse(params));
            logger.debug("Send command: {} -> {} (Device: {} token: {})", fullCommand.toString(), ip,
                    Utils.getHex(deviceId), Utils.getHex(token));
            MiIoSendCommand sendCmd = new MiIoSendCommand(cmdId, MiIoCommand.getCommand(command),
                    fullCommand.toString());
            commandsSend.put(Integer.valueOf(cmdId), sendCmd);
            concurrentLinkedQueue.add(sendCmd);
            return sendCommand(fullCommand.toString(), token, ip, deviceId);
            // return "id#" + Integer.toString(cmdId);
        } catch (JsonSyntaxException e) {
            logger.warn("Send command '{}' with parameters {} -> {} (Device: {}) gave error {}", command, params, ip,
                    Utils.getHex(deviceId), e.getMessage());
            throw e;
        }
    }

    private void startSend() {
        MiIoSendCommand cmd = concurrentLinkedQueue.poll();
        try {
            sendCommand(cmd.getCommandString(), token, ip, deviceId);
        } catch (MiIoCryptoException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private String sendCommand(String command, byte[] token, String ip, byte[] deviceId)
            throws MiIoCryptoException, IOException {
        byte[] encr;
        encr = MiIoCrypto.encrypt(command.getBytes(), token);
        timeStamp = (int) TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().getTime().getTime());
        byte[] sendMsg = Message.createMsgData(encr, token, deviceId, timeStamp + timeDelta);
        Message miIoResponseMsg = sendData(sendMsg, ip);

// if (miIoResponseMsg == null) {
// if (logger.isTraceEnabled()) {
// logger.trace("No response from device {} at {} for command {}.\r\n{}", Utils.getHex(deviceId), ip,
// command, (new Message(sendMsg)).toSting());
// } else {
// logger.debug("No response from device {} at {} for command {}.", Utils.getHex(deviceId), ip, command);
// }
//
        return null;
    }

    public void sendPing(String ip) throws IOException {
        timeStamp = (int) TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().getTime().getTime()) - 5;
        sendData(MiIoBindingConstants.DISCOVER_STRING, ip);
    }

    private Message sendData(byte[] sendMsg, String ip) throws IOException {
        ssocket.sendMessage(sendMsg, InetAddress.getByName(ip), MiIoBindingConstants.PORT);
        return null;
    }

    public void close() {
        ssocket.unregisterListener(this);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id.incrementAndGet();
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id.set(id);
    }

    /**
     * Time delta between device time & server time
     */
    public int getTimeDelta() {
        return timeDelta;
    }

    public byte[] getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(byte[] deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public void onDataReceived(byte[] message) {
        if (message.length >= 32) {
            Message miIoResponse = new Message(message);
            timeDelta = miIoResponse.getTimestampAsInt() - timeStamp;
            if (message.length == 32) {
                if (logger.isTraceEnabled()) {
                    logger.trace("Received ping response from {}:{}", ip, new Message(message).toSting());
                } else {
                    logger.debug("Received ping response from {}", ip, new Message(message).toSting());
                }
            } else {
                try {
                    if (logger.isTraceEnabled()) {
                        logger.trace("Received msg response from {}:{}", ip, new Message(message).toSting());
                    }

                    String decryptedResponse = new String(MiIoCrypto.decrypt(miIoResponse.getData(), token)).trim();
                    JsonElement response = parser.parse(decryptedResponse);
                    if (response.isJsonObject()) {
                        logger.info("Received  message {}", response.toString());

                        if (response.getAsJsonObject().get("id").isJsonPrimitive()) {
                            Integer id = response.getAsJsonObject().get("id").getAsInt();
                            if (commandsSend.containsKey(id)) {
                                logger.trace("Key found {}", commandsSend.containsKey(id));
                                MiIoSendCommand cmd = commandsSend.remove(id);
                                cmd.setResponse(response.getAsJsonObject());
                                for (MiIoMessageListener listener : listeners) {
                                    logger.trace("inform listener {}, data {} from {}", listener);
                                    try {
                                        listener.onMessageReceived(cmd);
                                    } catch (Exception e) {
                                        logger.debug("Could not inform listener {}, data {} from {}: ", listener,
                                                e.getMessage(), e);
                                    }
                                }

                            }
                        }
                    } else {
                        logger.info("Received message is invalid JSON: {}", decryptedResponse);
                    }

                } catch (MiIoCryptoException e) {
                    logger.info("could not decrypt message {}", new Message(message).toSting());
                }
            }
            logger.trace("Message Details: {}", miIoResponse.toSting());
        }
    }
}
