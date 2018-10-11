package org.openhab.binding.miio.internal.gateway.service;

import com.google.gson.JsonObject;
import org.openhab.binding.miio.internal.MiIoSendCommand;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by wfred on 07.10.18.
 */
public class ResponseHandler<T> {

    private Function<JsonObject, T> translator;
    private Consumer<T> consumer;

    public ResponseHandler(Function<JsonObject, T> translator, Consumer<T> consumer) {
        this.translator = translator;
        this.consumer = consumer;
    }

    public void handle(MiIoSendCommand command) {
        consumer.accept(translator.apply(command.getResponse()));
    }

}
