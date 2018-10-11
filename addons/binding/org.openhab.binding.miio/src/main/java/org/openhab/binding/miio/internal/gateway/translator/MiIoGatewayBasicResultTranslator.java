package org.openhab.binding.miio.internal.gateway.translator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.openhab.binding.miio.internal.gateway.vo.MiIoGatewayBasicInfo;
import org.openhab.binding.miio.internal.gateway.vo.MiIoLedColor;

import java.util.function.Function;

/**
 * Created by wfred on 07.10.18.
 */
public class MiIoGatewayBasicResultTranslator implements Function<JsonObject, MiIoGatewayBasicInfo> {
    @Override
    public MiIoGatewayBasicInfo apply(JsonObject jsonObject) {
        JsonElement result = jsonObject.get("result");
        if (result.isJsonArray()) {
            JsonArray array = result.getAsJsonArray();

            boolean armed = array.get(0).getAsString().equalsIgnoreCase("on ");
            MiIoLedColor nightLight = MiIoLedColor.fromRgbAndBrightness(array.get(1).getAsLong());
            MiIoLedColor color = MiIoLedColor.fromRgbAndBrightness(array.get(2).getAsLong());
            Long illumination = array.get(3).getAsLong();

            return new MiIoGatewayBasicInfo(armed, nightLight, color, illumination);
        }

        throw new RuntimeException("Unhandled response type: " + jsonObject.toString());

    }
}
