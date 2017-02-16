/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.onkyo.internal;

import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.types.State;

/**
 * Class to support parsing of Onkyo data blocks.
 *
 * @author Marcel Verpaalen - Initial contribution
 */
public final class OnkyoParserHelper {

    
    /**
     * Format the audio/video info to a formatted string.  
     * @param data EISCP audio/video info 
     * @param from first element to include
     * @param to last element to include
     */
    public static State infoBuilder(String data, int from, int to) {
        StringBuilder builder = new StringBuilder();

        String[] element = data.split(",");
        if (element.length < from) {
            return StringType.EMPTY;
        }
        if (element.length < to) {
            to = element.length;
        }

        for (int i = from; i < to; i++) {
            if (!element[i].isEmpty() && i != from) {
                builder.append(", ");
            }
            builder.append(element[i]);
        }
        return new StringType(builder.toString());
    }

    /**
     * Format the preset message to a state string
     * @param preset EISCP preset data
     */
    public static State presetParser(String preset) {
        String presetText = "";
        if (preset.equals("00")) {
            presetText = "No Preset";
        } else {
            try {
                presetText = Integer.decode("0x" + preset).toString();
            } catch (NumberFormatException e) {
                presetText = "Unknown";
            }
        }
        return new StringType(presetText);
    }

}
