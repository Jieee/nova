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

package org.nova.net.packet.codec.impl;

import org.nova.net.packet.Packet;
import org.nova.net.packet.codec.PacketCodecState;

/**
 * Created by Hadyn Richard
 */
public final class PacketEncoderState extends PacketCodecState {

    /**
     * The packet to be encoded.
     */
    private Packet packet;

    /**
     * Constructs a new {@link PacketEncoderState};
     */
    public PacketEncoderState() {}

    /**
     * Sets the packet to be encoded.
     *
     * @param packet    The packet to be encoded.
     */
    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    /**
     * Gets the packet to be encoded.
     *
     * @return  The packet to be encoded.
     */
    public Packet getPacket() {
        return packet;
    }
}
