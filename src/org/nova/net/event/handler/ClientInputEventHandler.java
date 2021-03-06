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

package org.nova.net.event.handler;

import org.nova.event.EventHandler;
import org.nova.event.EventHandlerChain;
import org.nova.event.EventHandlerChainContext;
import org.nova.net.ISAACCipher;
import org.nova.net.event.PacketParsedEvent;
import org.nova.net.packet.Packet;
import org.nova.net.event.ClientInputEvent;
import org.nova.net.packet.codec.impl.PacketDecoder;
import org.nova.net.packet.codec.impl.PacketDecoderState;
import org.nova.net.packet.codec.impl.PacketDecoderState.Stage;

import java.nio.ByteBuffer;

/**
 * Created by Hadyn Richard
 */
public final class ClientInputEventHandler extends EventHandler<ClientInputEvent> {

    /**
     * The decoder to use in order to decode packets for this handler.
     */
    private PacketDecoder decoder;

    /**
     * The event handler chain to propagate the packet parsed events down.
     */
    private EventHandlerChain<PacketParsedEvent> chain;

    /**
     * Constructs a new {@link ClientInputEventHandler};
     *
     * @param decoder   The decoder to use in order to decode packets.
     * @param chain     The event handler chain to propagate the parsed packet events down.
     */
    public ClientInputEventHandler(PacketDecoder decoder, EventHandlerChain<PacketParsedEvent> chain) {
        this.decoder = decoder;
        this.chain = chain;
    }

    @Override
    public void handle(ClientInputEvent event, EventHandlerChainContext<ClientInputEvent> context) {

        /* Check if the packet descriptor needs to be determined */
        PacketDecoderState state = event.getClient().getDecoderState();
        if(state.getStage().equals(Stage.AWAITING_ID)) {

            /* Check if we can parse the packet id from the buffer */
            ByteBuffer buffer = state.getBuffer();
            if(buffer.remaining() < 1) {

                /* Stop propagating any further past this point */
                context.stop();

                /* Stop the context from looping */
                event.getContext().setLoop(false);
                return;
            }

            int id = buffer.get() & 0xFF;

            /* Check if the id needs to be deciphered */
            if(state.useCipher()) {

                ISAACCipher cipher = state.getCipher();
                if(cipher == null) {
                    throw new IllegalStateException("cipher cannot be null");
                }

                id = id - cipher.getNextValue() & 0xFF;
            }

            /* Set the id and that we are now awaiting bytes */
            state.setDecoderId(id);
            state.setStage(Stage.AWAITING_BYTES);
        }

        /* Check if this is the correct handler for the packet to decode */
        if(decoder.getId() != state.getDecoderId()) {
            return;
        }

        /* Check to see if the type of service for the client is correct */
        if(!event.getClient().getServiceType().equals(decoder.getServiceType())) {
            return;
        }

        /* Stop propagating any further past this point */
        context.stop();

        /* Decode the packet and check if it successfully decoded */
        Packet packet = decoder.decode(state);
        if(packet == null) {

            /* Stop the context from looping */
            event.getContext().setLoop(false);

            return;
        }

        /* Get the buffer that was used to parse the packet and compact, and rewind it */
        ByteBuffer buffer = state.getBuffer();
        buffer.compact().rewind();

        /* Alert that we are now awaiting for an id again */
        state.setStage(Stage.AWAITING_ID);

        /* Tell the context to continue looping */
        event.getContext().setLoop(true);

        /* Create and propagate the packet event down the event handler chain */
        PacketParsedEvent packetEvent = new PacketParsedEvent(event.getClient(), packet);
        chain.createNewEventHandlerChainContext(packetEvent).doAll();
    }
}
