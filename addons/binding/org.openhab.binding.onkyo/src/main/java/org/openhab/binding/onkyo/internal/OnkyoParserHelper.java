package org.openhab.binding.onkyo.internal;

import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.types.State;

public final class OnkyoParserHelper {

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

    public static State presetParser(String value) {
        String presetText = "";
        if (value.equals("00")) {
            presetText = "No Preset";
        } else {
            try {
                presetText = Integer.decode("0x" + value).toString();
            } catch (NumberFormatException e) {
                presetText = "Unknown";
            }
        }
        return new StringType(presetText);
    }

}
