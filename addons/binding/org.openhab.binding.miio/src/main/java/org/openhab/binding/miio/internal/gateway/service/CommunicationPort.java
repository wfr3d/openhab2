package org.openhab.binding.miio.internal.gateway.service;

import org.openhab.binding.miio.internal.MiIoCommand;

/**
 * Created by wfred on 07.10.18.
 */
public interface CommunicationPort {
    int sendCommand(MiIoCommand command, String params);
}
