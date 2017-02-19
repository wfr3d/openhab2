package org.openhab.binding.onkyo.internal.config;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ReceiverInfo {

    private Logger logger = LoggerFactory.getLogger(ReceiverInfo.class);

    private String xmlString;
    private String device;
    private String model;
    private String destination;
    private String macaddress;

    //netservicelist

    private ReceiverInfo(String nriMessage) {
        XStream xstream = new XStream();
        xstream.processAnnotations(RadioChannels.class);
        RadioChannels RadioChannels = (RadioChannels) xstream.fromXML(nriMessage);
        //ReceiverInfo newJoe = (ReceiverInfo) xstream.fromXML(nriMessage);
        logger.debug("log{}", RadioChannels.toString());
    }

    public static ReceiverInfo parseNri(String nriMessage) {
        ReceiverInfo info = new ReceiverInfo(nriMessage);
        return info;
    }

    public String getDevice() {
        return device;
    }
    /*
    <brand>ONKYO</brand>
    <category>AV Receiver</category>
    <year>2016</year>
    <model>TX-NR656</model>
    <destination>xx</destination>
    <macaddress>0009B0E009A8</macaddress>
    <modeliconurl>http://192.168.3.52/icon/OAVR_120.jpg</modeliconurl>
    */

    public String getModel() {
        return model;
    }

    public String getDestination() {
        return destination;
    }

    public String getMacaddress() {
        return macaddress;
    }

    @XStreamAlias("netservicelist")
    public class RadioChannels {
        public ArrayList<RadioChannel> netServices;
    }

    class RadioChannel {
        //        <netservice id="0e" value="1" name="TuneIn Radio" account="Username" password="Password" />

        String id;
        String value;
        String name;
        String account;
        String password;

        @Override
        public String toString() {
            return "Net Service [id=" + id + " name=" + name + "]";
        }

    }

    @Override
    public String toString() {
        return xmlString;
    }
}