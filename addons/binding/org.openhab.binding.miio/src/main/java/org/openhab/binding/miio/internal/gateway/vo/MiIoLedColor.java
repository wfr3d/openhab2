package org.openhab.binding.miio.internal.gateway.vo;

import org.apache.commons.lang.Validate;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by wfred on 07.10.18.
 */
public class MiIoLedColor implements Serializable {

    private int red;
    private int green;
    private int blue;
    private int brightness;

    private MiIoLedColor() {
    }

    private MiIoLedColor(int red, int green, int blue, int brightness) {
        Validate.isTrue(red >= 0 && red <= 255);
        Validate.isTrue(green >= 0 && green <= 255);
        Validate.isTrue(blue >= 0 && blue <= 255);
        Validate.isTrue(brightness >= 0 && brightness <= 255);

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.brightness = brightness;
    }

    public static MiIoLedColor fromRgb(int red, int green, int blue) {
        MiIoLedColor color = new MiIoLedColor(red, green, blue, 255);

        return color;
    }

    public static MiIoLedColor fromRgbAndBrightness(long allInOne) {
        Validate.isTrue(allInOne >= 0);

        int brightness = (int) ((allInOne & 0xFF000000) >> 24);
        int red = (int) ((allInOne & 0x00FF0000) >> 16);
        int green = (int) ((allInOne & 0x0000FF00) >> 8);
        int blue = (int) ((allInOne & 0x000000FF) );


        return new MiIoLedColor(red, green, blue, brightness);
    }

    public static MiIoLedColor fromHsb(int hue, int saturation, int brightness) {
        Validate.isTrue(hue >= 0 && hue <= 360);
        Validate.isTrue(saturation >= 0 && saturation <= 100);
        Validate.isTrue(brightness >= 0 && brightness <= 100);


        Color color = Color.getHSBColor(1.0f*hue/360.0f,
                1.0f * saturation / 100.0f, 1.0f);

        int brightness2 = (int) (255.0 * (brightness/100.0));

        return  new MiIoLedColor(color.getRed(), color.getGreen(), color.getBlue(), brightness2);
    }


    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getBrightness() {
        return brightness;
    }

    public int getBrightnessPercent() {
        return (int) Math.round(brightness / 255.0 * 100.0);
    }

    public long getAllInOne() {
        long allInOne = ((long)brightness << 24) + (red << 16) + (green << 8) + blue;

        return allInOne;
    }

    public MiIoLedColor setBrightnessPercent(int percent) {
        Validate.isTrue(percent >= 0 && percent <= 100);

        int newBrightness = (int) (255.0 * (percent/100.0));

        return new MiIoLedColor(red, green, blue, newBrightness);
    }

    public String toHsbString() {
        float[] hsb = Color.RGBtoHSB(red, green, blue, null);

        return "" + (int)(hsb[0]*360) + "," + (int)(hsb[1]*100) + "," + (int)(hsb[2]*100);
    }
}
