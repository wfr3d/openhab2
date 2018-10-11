package org.openhab.binding.miio.internal.gateway.translator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.function.Function;

/**
 * Created by wfred on 09.10.18.
 */
//todo: write TEST!!!
public class MiIoNumericResultTranslator implements Function<JsonObject, Long> {


    @Override
    public Long apply(JsonObject jsonObject) {
        JsonElement result = jsonObject.get("result");
        if (result.isJsonArray()) {
            JsonArray array = result.getAsJsonArray();
            if (array.size() == 1) {
                return array.get(0).getAsLong();
            }
        }

        throw new RuntimeException("Unhandled response type: " + jsonObject.toString());
    }
}
