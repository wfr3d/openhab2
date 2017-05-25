/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nefit;

/**
 * The {@link NefitBindingConfiguration} class defines variables which are
 * used for the binding configuration.
 *
 * @author Marcel Verpaalen - Initial contribution
 */
public final class NefitBindingConfiguration {
    public String serialNumber;
    public String accessKey;
    public String password;
    public int refreshInterval;
}