package org.openhab.binding.miio.internal.gateway.translator;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.openhab.binding.miio.internal.gateway.vo.MiIoGatewayFmChannelsInfo;

/**
 * Created by wfred on 09.10.18.
 */
public class MiIoGatewayFmChannelResultTranslatorTest {

    @Test
    public void realLifeResponse() {
        JsonObject json = new JsonParser().parse("{\"result\":{\"chs\":[{\"id\":252,\"type\":0,\"url\":\"http:\\/\\/live.xmcdn.com\\/live\\/252\\/64.m3u8\"}, {\"id\":1065,\"type\":0,\"url\":\"http:\\/\\/live.xmcdn.com\\/live\\/1065\\/64.m3u8\"}]},\"id\":65048}").getAsJsonObject();

        MiIoGatewayFmChannelsInfo channels = new MiIoGatewayFmChannelResultTranslator().apply(json);

        Assert.assertEquals(2, channels.getChannels().size());

        Assert.assertEquals(252, channels.getChannels().get(0).getId());
        Assert.assertEquals(1065, channels.getChannels().get(1).getId());
    }
}