package org.openhab.binding.miio.internal.gateway.vo;

import java.io.Serializable;

/**
 * Created by wfred on 09.10.18.
 */
public class MiIoGatewayFmChannelInfo implements Serializable {
    private long id;
    private int type;
    private String url;

    protected MiIoGatewayFmChannelInfo() {
    }

    public MiIoGatewayFmChannelInfo(long id, int type, String url) {
        this.id = id;
        this.type = type;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
