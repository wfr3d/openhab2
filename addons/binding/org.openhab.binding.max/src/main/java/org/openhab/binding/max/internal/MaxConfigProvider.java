package org.openhab.binding.max.internal;

import java.net.URI;
import java.util.Collection;
import java.util.Locale;

import org.eclipse.smarthome.config.core.ConfigOptionProvider;
import org.eclipse.smarthome.config.core.ParameterOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxConfigProvider implements ConfigOptionProvider {

    private final static Logger logger = LoggerFactory.getLogger(MaxConfigProvider.class);

    @Override
    public Collection<ParameterOption> getParameterOptions(URI uri, String param, Locale locale) {

        logger.debug("MAX Collection URI {}", uri);
        logger.debug("MAX Collection param {}", param);
        logger.debug("MAX Collection locale {}", locale);

        return null;
    }

}
