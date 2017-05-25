package org.openhab.binding.nefit.internal.transport;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.chat2.IncomingChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.openhab.binding.nefit.internal.NefitMessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NefitConnection {
    private final Logger logger = LoggerFactory.getLogger(NefitConnection.class);
    public static final String ACCESSKEY_PREFIX = "Ct7ZR03b_";
    public static final String RRC_CONTACT_PREFIX = "rrccontact_";
    public static final String RRC_GATEWAY_PREFIX = "rrcgateway_";

    public static final String HOST = "wa2-mz36-qrmzh6.bosch.de";

    private String serialNumber;
    private String accessKey;
    private String password;
    private XMPPTCPConnection connection;
    private List<NefitMessageListener> listeners = new CopyOnWriteArrayList<>();
    private ChatManager chatManager;
    private Chat chat;
    private String suffix;
    private String jid;
    private String tojid;
    private String username;
    private byte[] key;

    public NefitConnection(String serialNumber, String accessKey, String pwd) {
        this.serialNumber = serialNumber;
        this.accessKey = accessKey;
        try {
            key = NefitCrypto.generateKey(accessKey, pwd);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            logger.trace("Error generating key {}", e.getMessage(), e);
        }
    }

    /**
     * Registers a {@link NefitMessageListener} to be called back, when data is received.
     * If no connection exists, when the method is called, it is being set up.
     *
     * @param listener - {@link NefitMessageListener} to be called back
     */
    public synchronized void registerListener(NefitMessageListener listener) {
        if (!getListeners().contains(listener)) {
            logger.trace("Adding  listener {}", listener);
            getListeners().add(listener);
        }
        if (connection == null) {
            intialize();
        }
    }

    private void intialize() {
        suffix = serialNumber + '@' + HOST;
        jid = RRC_CONTACT_PREFIX + suffix;
        tojid = RRC_GATEWAY_PREFIX + suffix;
        username = RRC_CONTACT_PREFIX + serialNumber;
        password = ACCESSKEY_PREFIX + accessKey;

        try {
            XMPPTCPConnectionConfiguration config = XMPPTCPConnectionConfiguration.builder().setHost(HOST)
                    .setXmppDomain(HOST).setUsernameAndPassword(jid, password).build();

            connection = new XMPPTCPConnection(config);
            // Stanza stanza = new Stanza();
            logger.debug("Start Connection to XMPP as '{}' has been established. Is secure/encrypted: {}", username,
                    password);

            connection.connect();
            logger.debug("Connection to XMPP as '{}' has been established. Is secure/encrypted: {}",
                    connection.isSecureConnection());

            connection.login();

            logger.debug("Connection to XMPP as '{}' has been established. Is secure/encrypted: {}",
                    connection.getUser(), connection.getUsedSaslMechansism());

            Presence presence = new Presence(Type.available);
            connection.sendStanza(presence);
            chatManager = ChatManager.getInstanceFor(connection);
            chatManager.addIncomingListener(new IncomingChatMessageListener() {
                @Override
                public void newIncomingMessage(EntityBareJid arg0, Message arg1, Chat arg2) {
                    logger.trace("Received new message from {}, content {}", arg0, arg1.getBody());
                    String msg = Utils.getBody(arg1.getBody());
                    String msgDecoded = "";
                    try {
                        msgDecoded = NefitCrypto.decrypt(key, msg);
                    } catch (Exception e) {
                        logger.debug("Error decryping {}: {}", msg, e.getMessage(), e);
                    }
                    if (msgDecoded.length() == 0) {
                        return;
                    }
                    for (NefitMessageListener listener : listeners) {
                        logger.trace("inform listener {}, data: {}", listener, Utils.getBody(arg1.getBody()));
                        try {
                            listener.onDataReceived(msgDecoded);
                        } catch (Exception e) {
                            logger.info("Could not inform listener {}: {}: ", listener, e.getMessage(), e);
                        }
                    }
                }
            });
            EntityBareJid tojid1 = JidCreate.entityBareFrom(tojid);

            chat = chatManager.chatWith(tojid1);

        } catch (Exception ex) {
            logger.debug("error while setup connection {}", ex.getMessage(), ex);
        }
    }

    /**
     * Unregisters a {@link XiaomiSocketListener}. If there are no listeners left,
     * the {@link XiaomiSocket} is being closed.
     *
     * @param listener - {@link XiaomiSocketListener} to be unregistered
     */
    public synchronized void unregisterListener(NefitMessageListener listener) {
        getListeners().remove(listener);

        if (getListeners().isEmpty()) {
            logger.info(" Closing Connection to XMPP connected:'{}'", connection.isConnected());
            connection.disconnect();
            logger.info("Done Closing Connection to XMPP connected:'{}'", connection.isConnected());
        }
    }

    protected List<NefitMessageListener> getListeners() {
        return listeners;
    }

    public void send(String cmd, String para) {
        try {
            Message newMessage = new Message();
            newMessage.setBody("GET " + cmd + " HTTP/1.1\rUser-Agent: NefitEasy\r\r");
            chat.send(newMessage);
        } catch (NotConnectedException | InterruptedException e) {
            logger.debug("Error while sending command {}: {}", cmd, e.getMessage(), e);
        }
    }

}
