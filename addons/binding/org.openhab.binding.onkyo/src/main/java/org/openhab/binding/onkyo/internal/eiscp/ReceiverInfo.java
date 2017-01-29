package org.openhab.binding.onkyo.internal.eiscp;

public class ReceiverInfo {
    private String device;
    private String model;
    private String destination;
    private String macaddress;

    private ReceiverInfo() {
    }

    public static ReceiverInfo parseNri(String nriMessage) {
        ReceiverInfo info = new ReceiverInfo();
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

}