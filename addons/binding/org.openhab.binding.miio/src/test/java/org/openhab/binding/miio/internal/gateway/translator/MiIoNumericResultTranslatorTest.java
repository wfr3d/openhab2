package org.openhab.binding.miio.internal.gateway.translator;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wfred on 09.10.18.
 */
public class MiIoNumericResultTranslatorTest {


    @Test
    public void realLifeResponse() {
        JsonObject json = new JsonParser().parse(" {\"result\":[54321],\"id\":10002}").getAsJsonObject();

        Long numericResult = new MiIoNumericResultTranslator().apply(json);

        Assert.assertEquals(54321l, numericResult.longValue());
    }



}