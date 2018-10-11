/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.miio.internal;

import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.miio.handler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openhab.binding.miio.MiIoBindingConstants.*;

/**
 * The {@link MiIoHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Marcel Verpaalen - Initial contribution
 */
public class MiIoHandlerFactory extends BaseThingHandlerFactory {

    private Logger logger = LoggerFactory.getLogger(MiIoHandlerFactory.class);

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        // todo: figure out how to get and inject discovery service here
//        Bundle bundle = FrameworkUtil.getBundle(DiscoveryService.class);
//        ServiceReference<DiscoveryService> serviceReference = this.bundleContext.getServiceReference(DiscoveryService.class);


        if (thingTypeUID.equals(THING_TYPE_MIIO)) {
            return new MiIoGenericHandler(thing);
        }
        if (thingTypeUID.equals(THING_TYPE_BASIC)) {
            return new MiIoBasicHandler(thing);
        }
        if (thingTypeUID.equals(THING_TYPE_VACUUM)) {
            return new MiIoVacuumHandler(thing);
        }
        if (thingTypeUID.equals(THING_TYPE_GATEWAY)) {
            return new MiIoGatewayHandler(thing);
        }
        if (thingTypeUID.equals(THING_TYPE_UNSUPPORTED)) {
            return new MiIoUnsupportedHandler(thing);
        }
        return null;
    }
}
