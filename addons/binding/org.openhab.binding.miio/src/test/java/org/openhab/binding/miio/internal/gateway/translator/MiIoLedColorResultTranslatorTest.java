package org.openhab.binding.miio.internal.gateway.translator;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;
import org.openhab.binding.miio.internal.gateway.vo.MiIoLedColor;

/**
 * Created by wfred on 07.10.18.
 */
public class MiIoLedColorResultTranslatorTest {

    @Test
    public void realLifeResponse() {
        JsonObject json = new JsonParser().parse("{\"result\":[ 1694433280 ],\"id\":3}").getAsJsonObject();

        MiIoLedColor color = new MiIoLedColorResultTranslator().apply(json);

        Assert.assertEquals(1694433280l, color.getAllInOne());
    }

}