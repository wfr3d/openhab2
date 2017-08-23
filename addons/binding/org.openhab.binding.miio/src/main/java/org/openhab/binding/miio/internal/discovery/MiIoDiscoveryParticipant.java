/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.miio.internal.discovery;

import static org.openhab.binding.miio.MiIoBindingConstants.*;

import java.net.InetAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jmdns.ServiceInfo;

import org.eclipse.smarthome.config.discovery.DiscoveryResult;
import org.eclipse.smarthome.config.discovery.DiscoveryResultBuilder;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.eclipse.smarthome.io.transport.mdns.discovery.MDNSDiscoveryParticipant;
import org.openhab.binding.miio.internal.MiIoDevices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * discovers Mi IO devices announced by mDNS
 *
 * @author Marcel Verpaalen
 *
 */
public class MiIoDiscoveryParticipant implements MDNSDiscoveryParticipant {

    private Logger logger = LoggerFactory.getLogger(MiIoDiscoveryParticipant.class);

    @Override
    public Set<ThingTypeUID> getSupportedThingTypeUIDs() {
        // return (SUPPORTED_THING_TYPES_UIDS);
        return Collections.singleton(THING_TYPE_VACUUM);
    }

    @Override
    public String getServiceType() {
        return "_miio._udp.local.";
    }

    @Override
    public ThingUID getThingUID(ServiceInfo service) {
        if (service != null) {
            logger.trace("ServiceInfo: {}", service);
            String id[] = service.getName().split("_miio");
            if (id.length != 2) {
                return null;
            }
            int did;
            try {
                did = Integer.parseInt(id[1]);
            } catch (Exception e) {
                return null;
            }
            ThingTypeUID thingType = MiIoDevices.getType(id[0].replaceAll("-", ".")).getThingType();
            logger.trace("mDNS {} identified as thingtype {}", id[0], thingType);
            String uidName = Integer.toHexString(did).toUpperCase();
            return new ThingUID(thingType, uidName);

        }
        return null;
    }

    private InetAddress getIpAddress(ServiceInfo service) {
        InetAddress address = null;
        for (InetAddress addr : service.getInet4Addresses()) {
            return addr;
        }
        // Fallback for Inet6addresses
        for (InetAddress addr : service.getInet6Addresses()) {
            return addr;
        }
        return address;
    }

    @Override
    public DiscoveryResult createResult(ServiceInfo service) {
        DiscoveryResult result = null;
        ThingUID uid = getThingUID(service);
        if (uid != null) {
            Map<String, Object> properties = new HashMap<>(2);
            // remove the domain from the name
            InetAddress ip = getIpAddress(service);
            if (ip == null) {
                return null;
            }
            String inetAddress = ip.toString().substring(1); // trim leading slash
            String label = service.getName();
            String id = uid.getId();
            properties.put(PROPERTY_HOST_IP, inetAddress);
            properties.put(PROPERTY_DID, id);
            result = DiscoveryResultBuilder.create(uid).withProperties(properties).withRepresentationProperty(id)
                    .withLabel(label).build();
            logger.debug("Mi IO mDNS Discovery found {} with address '{}:{}' name '{}'", uid, inetAddress,
                    service.getPort(), label);
        }
        return result;
    }
}