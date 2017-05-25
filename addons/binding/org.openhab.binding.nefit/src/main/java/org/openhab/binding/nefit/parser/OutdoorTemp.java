package org.openhab.binding.nefit.parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OutdoorTemp extends MessageParser {

    public final static String ENDPOINT = "/system/sensors/temperatures/outdoor_t1";
    private Float temperature;
    private boolean isValid;
    private String unitOfMeasure;
    private String srcType;
    private String status;
    private float minValue;
    private float maxValue;

    public OutdoorTemp(String raw) {
        super(raw);
    }

    // ,"type":"floatValue","recordable":0,"writeable":0,"value":19,"unitOfMeasure":"C","minValue":-25,"maxValue":50,"status":"ok","srcType":"physical"}
    @Override
    void parseValues(String input) {
        JsonParser parser = new JsonParser();
        JsonObject nefitData = (JsonObject) parser.parse(input);
        this.temperature = nefitData.get("value").getAsFloat();
        this.unitOfMeasure = nefitData.get("value").getAsString();
        this.minValue = nefitData.get("minValue").getAsFloat();
        this.maxValue = nefitData.get("maxValue").getAsFloat();
        this.status = nefitData.get("status").getAsString();
        this.srcType = nefitData.get("srcType").getAsString();
    }

    public boolean isValid() {
        return isValid;
    }

    public Float getTemperature() {
        return temperature;
    }

    public String getSrcType() {
        return srcType;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public String getStatus() {
        return status;
    }

    public float getMinValue() {
        return minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    @Override
    public String toString() {
        return "Outdoor Temp: " + temperature + unitOfMeasure;
    }

}
