package org.openhab.binding.miio.internal.gateway.translator;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.openhab.binding.miio.internal.gateway.vo.MiIoGatewayFmInfo;

import java.util.function.Function;

/**
 * Created by wfred on 09.10.18.
 */
public class MiIoGatewayFmInfoResultTranslator implements Function<JsonObject, MiIoGatewayFmInfo> {
    @Override
    public MiIoGatewayFmInfo apply(JsonObject jsonObject) {
        JsonElement result = jsonObject.get("result");
        if (result.isJsonObject()) {
            Long currentProgram = result.getAsJsonObject().get("current_program").getAsLong();
            Long currentProgress = result.getAsJsonObject().get("current_progress").getAsLong();
            Long currentVolume = result.getAsJsonObject().get("current_volume").getAsLong();
            String currentStatus = result.getAsJsonObject().get("current_status").getAsString();

            return new MiIoGatewayFmInfo(currentProgram, currentProgress, currentVolume, currentStatus);
        }

        throw new RuntimeException("Unhandled response type: " + jsonObject.toString());
    }
}
