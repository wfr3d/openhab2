package org.openhab.binding.miio.internal.gateway.translator;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.openhab.binding.miio.internal.gateway.vo.MiIoGatewayFmChannelInfo;
import org.openhab.binding.miio.internal.gateway.vo.MiIoGatewayFmChannelsInfo;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wfred on 09.10.18.
 */
public class MiIoGatewayFmChannelResultTranslator implements Function<JsonObject, MiIoGatewayFmChannelsInfo> {


    private Function<JsonObject, MiIoGatewayFmChannelInfo> channelFunction = new MiIoGatewayFmChannelTranslator();

    @Override
    public MiIoGatewayFmChannelsInfo apply(JsonObject jsonObject) {
        JsonElement result = jsonObject.get("result");
        if (result.isJsonObject()) {
            JsonElement channels = result.getAsJsonObject().get("chs");
            if (channels.isJsonArray()) {
                List<MiIoGatewayFmChannelInfo> parsedChannels = IntStream.range(0, channels.getAsJsonArray().size())
                        .mapToObj(i -> channels.getAsJsonArray().get(i).getAsJsonObject())
                        .map(channelFunction::apply)
                        .collect(Collectors.toList());

                return new MiIoGatewayFmChannelsInfo(parsedChannels);
            }
        }

        throw new RuntimeException("Unhandled response type: " + jsonObject.toString());
    }
}
