package org.openhab.binding.nefit.parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Status extends MessageParser {
    public Status(String raw) {
        super(raw);
    }

    public final static String ENDPOINT = "/ecus/rrc/uiStatus";
    private Float roomTemperature;
    private boolean isValid;
    private String userMode;
    private String srcType;
    private String status;
    private float minValue;
    private float setPointTemperature;

    // {"user mode":"clock","clock program":"auto","in house status":"ok","in house temp":25,"hot water
    // active":true,"boiler indicator":"off","control":"room","temp override duration":0,"current switchpoint":19,"ps
    // active":false,"powersave mode":false,"fp active":false,"fireplace mode":false,"temp override":false,"holiday
    // mode":false,"boiler block":null,"boiler lock":null,"boiler maintenance":null,"temp setpoint":17,"temp override
    // temp setpoint":21,"temp manual setpoint":15,"hed enabled":null,"hed device at home":null,"outdoor
    // temp":21,"outdoor source type":"physical"}
    // {"id":"/ecus/rrc/uiStatus","type":"uiUpdate","recordable":0,"writeable":0,"value":{"CTD":"2017-05-24T15:42:35+01:00
    // We","CTR":"room","UMD":"clock","MMT":"15.0","CPM":"auto","CSP":"19","TOR":"off","TOD":"0","TOT":"21.0","TSP":"17.0","IHT":"25.00","IHS":"ok","DAS":"off","TAS":"off","HMD":"off","ARS":"init","FPA":"off","ESI":"off","BAI":"No","BLE":"false","BBE":"false","BMR":"false","PMR":"false","RS":"off","DHW":"on","HED_EN":"false","HED_DEV":"false","FAH":"false","DOT":"false","HED_DB":""}}
    /*
     * "ARS": "init",
     * "BAI": "No",
     * "BBE": "false",
     * "BLE": "false",
     * "BMR": "false",
     * "CPM": "auto",
     * "CSP": "8",
     * "CTD": "2017-05-29T17:21:02+01:00 Mo",
     * "CTR": "room",
     * "DAS": "off",
     * "DHW": "on",
     * "DOT": "false",
     * "ESI": "off",
     * "FAH": "false",
     * "FPA": "off",
     * "HED_DB": "",
     * "HED_DEV": "false",
     * "HED_EN": "false",
     * "HMD": "off",
     * "IHS": "ok",
     * "IHT": "27.40",
     * "MMT": "15.0",
     * "PMR": "false",
     * "RS": "off",
     * "TAS": "off",
     * "TOD": "0",
     * "TOR": "off",
     * "TOT": "21.0",
     * "TSP": "20.0",
     * "UMD": "clock"
     */
    @Override
    void parseValues(String input) {
        JsonParser parser = new JsonParser();
        JsonObject nefitData = (JsonObject) parser.parse(input);
        nefitData = nefitData.get("value").getAsJsonObject();
        this.userMode = nefitData.get("UMD").getAsString();
        this.roomTemperature = nefitData.get("IHT").getAsFloat();
        this.setPointTemperature = nefitData.get("TSP").getAsFloat();
    }

    public boolean isValid() {
        return isValid;
    }

    public Float getTemperature() {
        return roomTemperature;
    }

    public String getSrcType() {
        return srcType;
    }

    public String getUnitOfMeasure() {
        return userMode;
    }

    public String getStatus() {
        return status;
    }

    public float getMinValue() {
        return minValue;
    }

    public float getsetPointTemperature() {
        return setPointTemperature;
    }

    @Override
    public String toString() {
        return "room Temp:" + getTemperature();
    }

}
