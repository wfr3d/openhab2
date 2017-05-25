/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nefit;

import java.util.Collections;
import java.util.Set;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link NefitBinding} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Marcel Verpaalen - Initial contribution
 */
public class NefitBindingConstants {

    public static final String BINDING_ID = "nefit";

    // List of all Thing Type UIDs
    public final static ThingTypeUID THING_TYPE_THERMOSTAT = new ThingTypeUID(BINDING_ID, "thermostat");

    public final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Collections.singleton(THING_TYPE_THERMOSTAT);

    // List of all Channel IDs
    public final static String CHANNEL_SET_TEMP = "settemperature";
    public final static String CHANNEL_ROOM_TEMP = "temperature";
    public final static String CHANNEL_OUTDOOR_TEMP = "outdoortemperature";

}
