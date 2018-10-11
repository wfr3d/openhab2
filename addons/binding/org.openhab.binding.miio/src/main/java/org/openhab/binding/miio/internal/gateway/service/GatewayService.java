package org.openhab.binding.miio.internal.gateway.service;

import org.apache.commons.lang.Validate;
import org.openhab.binding.miio.internal.MiIoCommand;
import org.openhab.binding.miio.internal.MiIoSendCommand;
import org.openhab.binding.miio.internal.gateway.translator.*;
import org.openhab.binding.miio.internal.gateway.vo.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by wfred on 07.10.18.
 */
public class GatewayService {

    private CommunicationPort communicationPort;

    private Map<Integer, ResponseHandler<?>> responseHandlers = new HashMap<>();

    public GatewayService(CommunicationPort communicationPort) {
        this.communicationPort = communicationPort;
    }

    public void setRgbColor(MiIoLedColor color) {
        communicationPort.sendCommand(MiIoCommand.SET_RGB, "[" + color.getAllInOne() + "]");
    }

    public void getRgbColor(Consumer<MiIoLedColor> resultConsumer) {
        int commandId = communicationPort.sendCommand(MiIoCommand.GET_PROPERTY, "[\"rgb\"]");

        if (commandId > 0) {
            responseHandlers.put(commandId, new ResponseHandler<>(new MiIoLedColorResultTranslator(), resultConsumer));
        }
    }

    public void getBasicInfo(Consumer<MiIoGatewayBasicInfo> resultConsumer) {
        int commandId = communicationPort.sendCommand(MiIoCommand.GET_PROPERTY, "[\"arming\",\"night_light_rgb\",\"rgb\", \"illumination\"]");

        if (commandId > 0) {
            responseHandlers.put(commandId, new ResponseHandler<>(new MiIoGatewayBasicResultTranslator(), resultConsumer));
        }
    }

    public void getNightLightRgb(Consumer<MiIoLedColor> resultConsumer) {
        /*
       -> {"id":2991,"method":"get_night_light_rgb","params":[]}
       <- {"result":[1694498638],"id":2991}
         */
        int commandId = communicationPort.sendCommand(MiIoCommand.GET_NIGHT_LIGHT_RGB, "[]");

        if (commandId > 0) {
            responseHandlers.put(commandId, new ResponseHandler<>(new MiIoLedColorResultTranslator(), resultConsumer));
        }


    }

    public void setNightLightRgb(MiIoLedColor color) {
        /*
         ->  {"id":2997,"method":"set_night_light_rgb","params":[1694433296]}
         <-  {"result":["ok"],"id":2997}
         */
        int commandId = communicationPort.sendCommand(MiIoCommand.SET_NIGHT_LIGHT_RGB, "[" + color.getAllInOne()  + "]");
    }


    public void getArmWaitTime(Consumer<Long> resultConsumer) {
        /*
         ->  data= {"id":10002,"method":"get_arm_wait_time","params":[]}
         <-  data= {"result":[5],"id":10002}
         */
        int commandId = communicationPort.sendCommand(MiIoCommand.GET_ARM_WAIT_TIME, "[]");

        if (commandId > 0) {
            responseHandlers.put(commandId, new ResponseHandler<>(new MiIoNumericResultTranslator(), resultConsumer));
        }
    }


    public void getPropertiesFm(Consumer<MiIoGatewayFmInfo> resultConsumer) {
        /*
          ->  data= {"id":65001,"method":"get_prop_fm","params":[null]}
          <-  data= {"result":{"current_program":252,"current_progress":0,"current_volume":15,"current_status":"pause"},"id":65001}
        */
        int commandId = communicationPort.sendCommand(MiIoCommand.GET_PROPERTY_FM, "[null]");

        if (commandId > 0) {
            responseHandlers.put(commandId, new ResponseHandler<>(new MiIoGatewayFmInfoResultTranslator(), resultConsumer));
        }
    }

    public void getFmLowRate(Consumer<Long> resultConsumer) {
        /*
         ->  data= {"id":65047,"method":"get_device_prop","params":["lumi.0","fm_low_rate"]}
         <-  data= {"result":[1],"id":65047}
         */
        int commandId = communicationPort.sendCommand(MiIoCommand.GET_DEVICE_PROPERTY, "[\"lumi.0\",\"fm_low_rate\"]");

        if (commandId > 0) {
            responseHandlers.put(commandId, new ResponseHandler<>(new MiIoNumericResultTranslator(), resultConsumer));
        }
    }

    public void getFmChannels(Consumer<MiIoGatewayFmChannelsInfo> resultConsumer) {
        //todo: possible pagination ??
        /*
         ->  data= {"id":65048,"method":"get_channels","params":{"start":0}}
         <-  data= {"result":{"chs":[{"id":252,"type":0,"url":"http:\/\/live.xmcdn.com\/live\/252\/64.m3u8"}, {"id":1065,"type":0,"url":"http:\/\/live.xmcdn.com\/live\/1065\/64.m3u8"}]},"id":65048}
         */
        int commandId = communicationPort.sendCommand(MiIoCommand.GET_FM_CHANNELS, "[ \"start\":0 ]");

        if (commandId > 0) {
            responseHandlers.put(commandId, new ResponseHandler<>(new MiIoGatewayFmChannelResultTranslator(), resultConsumer));
        }

    }


    // todo: debug "type" and solve what it is
    public void playSpecifyFm(MiIoGatewayFmChannelInfo channelInfo) {
        /*
         ->  data= {"id":65010,"method":"play_specify_fm","params":{"id":252,"type":0,"url":"http:\/\/live.xmcdn.com\/live\/252\/64.m3u8"}}
         <-  data= {"result":["ok"],"id":65010}
         */
        communicationPort.sendCommand(MiIoCommand.PLAY_SPECIFY_FM, "[ "
                + "\"id\":" + channelInfo.getId()
                + ", \"type\":" + channelInfo.getType()
                + ", \"url\":\"" + channelInfo.getUrl() +"\" ]");
    }

    public void startPlayingFm() {
        playFm(true);
    }

    public void stopPlayingFm() {
        playFm(false);
    }

    private void playFm(boolean flag) {
        /*
         ->  data= {"id":65011,"method":"play_fm","params":["off"]}
         <-  data= {"result":["ok"],"id":65011}
         */
        String param = (flag) ? "on" : "off";

        communicationPort.sendCommand(MiIoCommand.PLAY_FM, "[ \"" +  param + "\" ]");
    }

    public void armAlarm() {
        setArming(true);
    }

    public void disarmAlarm() {
        setArming(false);
    }

    private void setArming(boolean flag) {
        /*
         ->  data= {"id":10005,"method":"set_arming","params":["on"]}
         <-  data= {"result":["ok"],"id":10005}
         */

        String param = (flag) ? "on" : "off";

        communicationPort.sendCommand(MiIoCommand.SET_ARMING, "[ \"" +  param + "\" ]");
    }

    public void setAlarmingVolume(int level) {
        setVolume(MiIoCommand.SET_ALARMING_VOLUME, level);
    }


    public void setDoorbellVolume(int level) {
        setVolume(MiIoCommand.SET_DOORBELL_VOLUME, level);
    }

    public void setGatewayVolume(int level) {
        setVolume(MiIoCommand.SET_GATEWAY_VOLUME, level);
    }

    public void setFmVolume(int level) {
        setVolume(MiIoCommand.SET_FM_VOLUME, level);
    }

    private void setVolume(MiIoCommand command, int level) {
        Validate.isTrue(level >= 0 && level <= 100, "Bad volume value [0-100]: " + level);

        /*
        ->  data= {"id":65033,"method":"set_alarming_volume","params":[29]}
        <-  data= {"result":["ok"],"id":65033}
        ->  data= {"id":65036,"method":"set_doorbell_volume","params":[9]}
        <-  data= {"result":["ok"],"id":65036}
        ->  data= {"id":65039,"method":"set_gateway_volume","params":[2]}
        <-  data= {"result":["ok"],"id":65039}
        ->  data= {"id":65041,"method":"set_fm_volume","params":[1]}
        <-  data= {"result":["ok"],"id":65041}
         */

        communicationPort.sendCommand(command, "[ " + level + " ]");
    }

    public void getGatewayVolume(Consumer<Long> resultConsumer) {
        getVolume(MiIoCommand.GET_GATEWAY_VOLUME, resultConsumer);
    }

    public void getAlarmingVolume(Consumer<Long> resultConsumer) {
        getVolume(MiIoCommand.GET_ALARMING_VOLUME, resultConsumer);
    }

    public void getDoorbellVolume(Consumer<Long> resultConsumer) {
        getVolume(MiIoCommand.GET_DOORBELL_VOLUME, resultConsumer);
    }

    //todo: check if exists get_fm_volume function ??

    private void getVolume(MiIoCommand command, Consumer<Long> resultConsumer) {
        /*
         ->  data= {"id":65030,"method":"get_gateway_volume","params":[]}
         <-  data= {"result":[0],"id":65030}
         ->  data= {"id":65031,"method":"get_alarming_volume","params":[]}
         <-  data= {"result":[0],"id":65031}
         ->  data= {"id":65032,"method":"get_doorbell_volume","params":[]}
         <-  data= {"result":[0],"id":65032}
         */

        int commandId = communicationPort.sendCommand(command, "[]");

        if (commandId > 0) {
            responseHandlers.put(commandId, new ResponseHandler<>(new MiIoNumericResultTranslator(), resultConsumer));
        }
    }

    public void startZigBeeJoin() {
        // ->  data= {"id":65030,"method":"start_zigbee_join","params":[ 30 ]}

        controllZigBeeJoin(30);
    }

    public void stopZigBeeJoin() {
        // ->  data= {"id":65030,"method":"start_zigbee_join","params":[ 0 ]}

        controllZigBeeJoin(0);
    }


    private void controllZigBeeJoin(int time) {
        communicationPort.sendCommand(MiIoCommand.START_ZIGBEE_JOIN, "[ " +  time + " ]");
    }

    public boolean onMessageReceived(MiIoSendCommand commandSend) {
        if (responseHandlers.containsKey(commandSend.getId())) {
            ResponseHandler<?> responseHandler = responseHandlers.get(commandSend.getId());
            responseHandlers.remove(commandSend.getId());
            responseHandler.handle(commandSend);
            return true;
        } else {
            return false;
        }

    }

}
