package org.openhab.binding.nefit.internal;
/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

import com.google.gson.JsonObject;

/**
 * Interface for a listener
 * When it is registered on the socket, it gets called back each time, we receive data.
 *
 * @author Marcel Verpaalen - Initial contribution
 */
public interface NefitMessageListener {
    /**
     * Callback method 
     *
     * @param message - The received message 
     */
    void onDataReceived(String message);
}
