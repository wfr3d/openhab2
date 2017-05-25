/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nefit.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Base parser for the responses .
 *
 * @author Marcel Verpaalen
 * @since 2.1
 */
public abstract class MessageParser {

    private String raw;
    private String id;
    private String type;
    private String recordable;
    private String writeable;
    private JsonElement value;

    public MessageParser(String raw) {
        this.raw = raw;
        parseHeader(raw);
        parseValues(raw);
    }

    private void parseHeader(String input) {
        JsonParser parser = new JsonParser();
        JsonObject nefitData = (JsonObject) parser.parse(input);
        this.id = nefitData.get("id").getAsString();
        this.type = nefitData.get("type").getAsString();
        this.recordable = nefitData.get("recordable").getAsString();
        this.writeable = nefitData.get("writeable").getAsString();
        this.value = nefitData.get("value");
    }

    abstract void parseValues(String input);

    @Override
    public abstract String toString();

    public String getRaw() {
        return raw;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getRecordable() {
        return recordable;
    }

    public String getWriteable() {
        return writeable;
    }

    public JsonElement getValue() {
        return value;
    }

}
