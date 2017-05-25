package org.openhab.binding.nefit.parser;

public class HeaderParser extends MessageParser {

    public HeaderParser(String raw) {
        super(raw);
    }

    @Override
    void parseValues(String input) {
        // ignore
    }

    @Override
    public String toString() {
        return "id:" + getId() + " Value " + getValue();
    }
}