package org.openhab.binding.miio.internal.gateway.translator;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.openhab.binding.miio.internal.gateway.vo.MiIoGatewayFmInfo;

/**
 * Created by wfred on 09.10.18.
 */
public class MiIoGatewayFmInfoResultTranslatorTest {


    @Test
    public void realLifeResponse() {
        JsonObject json = new JsonParser().parse("{\"result\":{\"current_program\":252,\"current_progress\":0,\"current_volume\":15,\"current_status\":\"pause\"},\"id\":65001}").getAsJsonObject();

        MiIoGatewayFmInfo result = new MiIoGatewayFmInfoResultTranslator().apply(json);

        Assert.assertEquals(252, result.getCurrentProgram().intValue());
        Assert.assertEquals(0, result.getCurrentProgress().intValue());
        Assert.assertEquals(15, result.getCurrentVolume().intValue());
        Assert.assertEquals("pause", result.getCurrentStatus());
    }

}