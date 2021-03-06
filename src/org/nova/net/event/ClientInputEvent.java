/**
 * Copyright (c) 2012, Hadyn Richard
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy 
 * of this software and associated documentation files (the "Software"), to deal 
 * in the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN 
 * THE SOFTWARE.
 */

package org.nova.net.event;

import org.nova.event.Event;
import org.nova.net.Client;
import org.nova.net.ClientInputContext;

/**
 * Created by Hadyn Richard
 */
public final class ClientInputEvent extends Event {

    /**
     * The client from which input was received.
     */
    private Client client;

    /**
     * The context from which the event was received from.
     */
    private ClientInputContext context;

    /**
     * Constructs a new {@link ClientInputEvent};
     *
     * @param client    The client from which the input was received.
     * @param context   The context from which the event was received from.
     */
    public ClientInputEvent(Client client, ClientInputContext context) {
        this.client = client;
        this.context = context;
    }

    /**
     * Gets the client.
     *
     * @return  The client.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Gets the context from which the event was received from.
     *
     * @return  The context.
     */
    public ClientInputContext getContext() {
        return context;
    }
}
