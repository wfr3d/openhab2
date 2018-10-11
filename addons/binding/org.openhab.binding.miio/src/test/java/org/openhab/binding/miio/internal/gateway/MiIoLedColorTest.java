package org.openhab.binding.miio.internal.gateway;

import org.junit.Assert;
import org.junit.Test;
import org.openhab.binding.miio.internal.gateway.vo.MiIoLedColor;

/**
 * Created by wfred on 07.10.18.
 */
public class MiIoLedColorTest {

    @Test
    public void goodRgbTest() {
        MiIoLedColor color = MiIoLedColor.fromRgb(123, 12, 21);

        Assert.assertEquals(123, color.getRed());
        Assert.assertEquals(12, color.getGreen());
        Assert.assertEquals(21, color.getBlue());
    }

    @Test
    public void testAllInOneWithRgb() {
        MiIoLedColor color = MiIoLedColor.fromRgb(0x7b, 0x0c, 0x15);

        Assert.assertEquals(0xFF7B0C15L, color.getAllInOne());
    }

    @Test
    public void testSetBrightnessPercent() {
        MiIoLedColor color = MiIoLedColor.fromRgb(123, 12, 21);

        color = color.setBrightnessPercent(50);

        Assert.assertEquals(127, color.getBrightness());
    }

    @Test
    public void testFromAllInOne() {
        MiIoLedColor color = MiIoLedColor.fromRgbAndBrightness(0x29112233L);

        Assert.assertEquals(0x29, color.getBrightness());
        Assert.assertEquals(0x11, color.getRed());
        Assert.assertEquals(0x22, color.getGreen());
        Assert.assertEquals(0x33, color.getBlue());
    }

    @Test
    public void testFromHsb() {
        MiIoLedColor color = MiIoLedColor.fromHsb(0, 100, 100);

        Assert.assertEquals(0xff, color.getBrightness());
        Assert.assertEquals(0xff, color.getRed());
        Assert.assertEquals(0x00, color.getGreen());
        Assert.assertEquals(0x00, color.getBlue());
    }

    @Test
    public void testBrightnessPercent() {
        MiIoLedColor color = MiIoLedColor.fromHsb(0, 100, 75);

        Assert.assertEquals(75, color.getBrightnessPercent());
    }

    @Test
    public void testHsbConversionTest() {
        MiIoLedColor color = MiIoLedColor.fromRgb(255, 0, 0);

        Assert.assertEquals("0,100,100", color.toHsbString());
    }

}