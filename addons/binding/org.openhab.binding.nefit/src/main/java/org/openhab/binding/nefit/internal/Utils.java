package org.openhab.binding.nefit.internal;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class Utils {

    public static String getData(String endpoint, String host, long port) throws IOException {

        String baseURL = "http://" + host + ":" + String.valueOf(port) + "/bridge";
        String urlString = baseURL + endpoint;

        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        return IOUtils.toString(connection.getInputStream());
    }

    public static String getBody(String html) {

        int loc = html.indexOf("\n\n");

        return html.substring(loc + 2);
    }
}