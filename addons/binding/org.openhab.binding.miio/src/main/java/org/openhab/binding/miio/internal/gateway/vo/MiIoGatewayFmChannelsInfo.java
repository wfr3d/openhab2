package org.openhab.binding.miio.internal.gateway.vo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by wfred on 09.10.18.
 */
public class MiIoGatewayFmChannelsInfo implements Serializable {

    private List<MiIoGatewayFmChannelInfo> channels;

    public MiIoGatewayFmChannelsInfo(List<MiIoGatewayFmChannelInfo> channels) {
        this.channels = channels;
    }

    public List<MiIoGatewayFmChannelInfo> getChannels() {
        return Collections.unmodifiableList(channels);
    }
}
