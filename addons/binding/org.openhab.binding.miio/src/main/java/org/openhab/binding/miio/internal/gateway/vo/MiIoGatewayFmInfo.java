package org.openhab.binding.miio.internal.gateway.vo;

import java.io.Serializable;

/**
 * Created by wfred on 09.10.18.
 */
public class MiIoGatewayFmInfo implements Serializable {
    private Long currentProgram;
    private Long currentProgress;
    private Long currentVolume;

    // todo: refactor to enum
    private String currentStatus;

    public MiIoGatewayFmInfo(Long currentProgram, Long currentProgress, Long currentVolume, String currentStatus) {
        this.currentProgram = currentProgram;
        this.currentProgress = currentProgress;
        this.currentVolume = currentVolume;
        this.currentStatus = currentStatus;
    }

    public Long getCurrentProgram() {
        return currentProgram;
    }

    public Long getCurrentProgress() {
        return currentProgress;
    }

    public Long getCurrentVolume() {
        return currentVolume;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }
}
