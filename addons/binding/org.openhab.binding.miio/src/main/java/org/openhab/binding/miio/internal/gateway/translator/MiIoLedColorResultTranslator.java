package org.openhab.binding.miio.internal.gateway.translator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.openhab.binding.miio.internal.gateway.vo.MiIoLedColor;

import java.util.function.Function;

/**
 * Created by wfred on 07.10.18.
 */
public class MiIoLedColorResultTranslator implements Function<JsonObject, MiIoLedColor> {

    @Override
    public MiIoLedColor apply(JsonObject json) {
        JsonElement result = json.get("result");
        if (result.isJsonArray()) {
            JsonArray array = result.getAsJsonArray();
            if (array.size() == 1) {
                return MiIoLedColor.fromRgbAndBrightness(array.get(0).getAsLong());
            }
        }

        throw new RuntimeException("Unhandled response type: " + json.toString());

    }
}
