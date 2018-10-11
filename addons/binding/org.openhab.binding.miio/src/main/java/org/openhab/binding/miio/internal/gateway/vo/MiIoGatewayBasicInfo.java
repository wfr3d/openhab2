package org.openhab.binding.miio.internal.gateway.vo;

import java.io.Serializable;

/**
 * Created by wfred on 07.10.18.
 */
public class MiIoGatewayBasicInfo implements Serializable {
    private boolean alarmArmed;
    private MiIoLedColor nightLight;
    private MiIoLedColor color;
    private Long illumination;

    public MiIoGatewayBasicInfo(boolean alarmArmed, MiIoLedColor nightLight, MiIoLedColor color, Long illumination) {
        this.alarmArmed = alarmArmed;
        this.nightLight = nightLight;
        this.color = color;
        this.illumination = illumination;
    }

    public boolean isAlarmArmed() {
        return alarmArmed;
    }

    public MiIoLedColor getNightLight() {
        return nightLight;
    }

    public Long getIllumination() {
        return illumination;
    }

    public MiIoLedColor getColor() {
        return color;
    }
}
