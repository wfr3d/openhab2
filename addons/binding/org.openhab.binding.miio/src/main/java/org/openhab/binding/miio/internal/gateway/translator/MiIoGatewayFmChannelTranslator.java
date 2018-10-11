package org.openhab.binding.miio.internal.gateway.translator;

import com.google.gson.JsonObject;
import org.openhab.binding.miio.internal.gateway.vo.MiIoGatewayFmChannelInfo;

import java.util.function.Function;

/**
 * Created by wfred on 09.10.18.
 */
public class MiIoGatewayFmChannelTranslator implements Function<JsonObject, MiIoGatewayFmChannelInfo> {

    @Override
    public MiIoGatewayFmChannelInfo apply(JsonObject jsonObject) {
        long id = jsonObject.get("id").getAsLong();
        int type = jsonObject.get("type").getAsInt();
        String url = jsonObject.get("url").getAsString();

        return new MiIoGatewayFmChannelInfo(id, type, url);
    }
}
