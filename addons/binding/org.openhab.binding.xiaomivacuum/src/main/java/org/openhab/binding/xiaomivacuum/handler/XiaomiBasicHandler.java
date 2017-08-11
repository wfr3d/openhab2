/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.xiaomivacuum.handler;

import static org.openhab.binding.xiaomivacuum.XiaomiVacuumBindingConstants.CHANNEL_COMMAND;

import java.io.IOException;
import java.net.URL;

import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.RefreshType;
import org.openhab.binding.xiaomivacuum.internal.Utils;
import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

/**
 * The {@link XiaomiBasicHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Marcel Verpaalen - Initial contribution
 */
public class XiaomiBasicHandler extends XiaomiMiIoAbstractHandler {
    private final Logger logger = LoggerFactory.getLogger(XiaomiBasicHandler.class);

    public XiaomiBasicHandler(Thing thing) {
        super(thing);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        if (command == RefreshType.REFRESH) {
            logger.debug("Refreshing {}", channelUID);
            updateData();
            return;
        }
        if (channelUID.getId().equals(CHANNEL_COMMAND)) {
            updateState(CHANNEL_COMMAND, new StringType(sendCommand(command.toString())));
        }
    }

    @Override
    protected synchronized void updateData() {
        logger.debug("Update connection '{}'", getThing().getUID().toString());
        if (!hasConnection()) {
            return;
        }
        try {
            if (updateNetwork()) {
                updateStatus(ThingStatus.ONLINE);
                if (!isIdentified) {
                    isIdentified = updateThingType(getJsonResultHelper(network.getValue()));
                }
            } else {
                disconnectedNoResponse();
            }
        } catch (Exception e) {
            logger.debug("Error while updating '{}'", getThing().getUID().toString(), e);
        }
    }

    @Override
    protected boolean initializeData() {
        this.roboCom = getConnection();
        if (roboCom != null) {
            updateStatus(ThingStatus.ONLINE);
        }
        initalizeNetworkCache();

        // For testing only
        Bundle bundle = bundleContext.getBundle();
        URL fn = bundle.getEntry("database/zhimi.airpurifier.m1.json");
        logger.debug("bundle: {}, {}, {}", bundle, fn.getFile(), fn);
        JsonObject cv;
        try {
            cv = Utils.convertFileToJSON(fn);
            logger.debug("reader: {}, {}, {}", fn.getFile(), cv.toString());
        } catch (JsonIOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;
    }

}
