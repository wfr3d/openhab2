package org.openhab.binding.max.internal;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

import org.eclipse.smarthome.config.core.ConfigDescription;
import org.eclipse.smarthome.config.core.ConfigDescriptionProvider;
import org.eclipse.smarthome.config.core.ConfigDescriptionRegistry;
import org.eclipse.smarthome.core.thing.ThingRegistry;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.eclipse.smarthome.core.thing.type.ThingType;
import org.eclipse.smarthome.core.thing.type.ThingTypeRegistry;
import org.openhab.binding.max.MaxBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxConfigDescriptionProvider implements ConfigDescriptionProvider {
    private final static Logger logger = LoggerFactory.getLogger(MaxConfigDescriptionProvider.class);

    private static ThingRegistry thingRegistry;
    private static ThingTypeRegistry thingTypeRegistry;
    private static ConfigDescriptionRegistry configDescriptionRegistry;

    protected void setThingRegistry(ThingRegistry thingRegistry) {
        MaxConfigDescriptionProvider.thingRegistry = thingRegistry;
        logger.debug("MAX setThingRegistry Called {}", thingRegistry.toString());

    }

    protected void unsetThingRegistry(ThingRegistry thingRegistry) {
        MaxConfigDescriptionProvider.thingRegistry = null;
    }

    protected void setThingTypeRegistry(ThingTypeRegistry thingTypeRegistry) {
        MaxConfigDescriptionProvider.thingTypeRegistry = thingTypeRegistry;
        logger.debug("MAX SET thingTypeRegistry Called {}", thingTypeRegistry.toString());

    }

    protected void unsetThingTypeRegistry(ThingTypeRegistry thingTypeRegistry) {
        MaxConfigDescriptionProvider.thingTypeRegistry = null;

    }

    protected void setConfigDescriptionRegistry(ConfigDescriptionRegistry configDescriptionRegistry) {
        MaxConfigDescriptionProvider.configDescriptionRegistry = configDescriptionRegistry;
        logger.debug("MAX SET configDescriptionRegistry Called {}", configDescriptionRegistry.toString());

    }

    protected void unsetConfigDescriptionRegistry(ConfigDescriptionRegistry configDescriptionRegistry) {
        MaxConfigDescriptionProvider.configDescriptionRegistry = null;
    }

    @Override
    public Collection<ConfigDescription> getConfigDescriptions(Locale locale) {
        logger.debug("MAX getConfigDescriptions (locale {})", locale);
        return Collections.emptySet();
    }

    @Override
    public ConfigDescription getConfigDescription(URI uri, Locale locale) {
        logger.debug("MAX getConfigDescriptions URI {}", uri);
        logger.debug("MAX getConfigDescriptions (locale {})", locale);

        if (uri == null) {
            return null;
        }

        if ("thing".equals(uri.getScheme()) == false) {
            return null;
        }

        ThingUID thingUID = new ThingUID(uri.getSchemeSpecificPart());
        ThingType thingType = thingTypeRegistry.getThingType(thingUID.getThingTypeUID());
        if (thingType == null) {
            return null;
        }

        // Is this a MAX! thing?
        if (!thingUID.getBindingId().equals(MaxBinding.BINDING_ID)) {
            return null;
        }

        /*
        // And make sure this is a node because we want to get the id off the end...
        if (!thingUID.getId().startsWith("node")) {
            return null;
        }
        */
        logger.debug("MAX getConfigDescriptions HELmaal(locale {})", thingUID.getId());

        return null;
    }

}
