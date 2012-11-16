/**
 * Copyright Evelus, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Hadyn Richard (sini@evel.us), July 2012
 */

package org.nova.net.event;

import org.nova.event.Event;
import org.nova.net.Packet;

/**
 * Evelus Development
 * Created by Hadyn Richard
 * 
 * The interface for all packet to event decoders.
 */
public interface EventDecoder<T extends Event> {
    
    /**
     * Decodes an event from a packet.
     * 
     * @param packet    The packet to decode the event from.
     * @return          The decoded event.
     */
    public T decode(Packet packet);

}
