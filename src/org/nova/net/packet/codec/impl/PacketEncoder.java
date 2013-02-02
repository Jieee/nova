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

import org.nova.net.packet.codec.PacketCodec;
import org.nova.util.Encoder;

import java.nio.ByteBuffer;

/**
 * Created by Hadyn Richard
 *
 * Notes:
 *
 *          Blocks are encoded in order by which they were entered into the encoder.
 *          TODO: Fix this.
 */
public final class PacketEncoder extends PacketCodec implements Encoder<ByteBuffer, PacketEncoderState> {

    /**
     * The descriptor for the packets to encode.
     */
    //private PacketDescriptor descriptor;

    /**
     * Construct a new {@link PacketEncoder};
     */
    public PacketEncoder() {
        //this.descriptor = descriptor;
    }

    @Override
    public ByteBuffer encode(PacketEncoderState state) {

        /* Get the packet to encode from the state */
        //Packet packet =  state.getPacket();

        /* Check if the packet contains the required blocks */
        //if(containsRequiredBlocks(packet)) {
        //    throw new IllegalStateException("packet does not contain required blocks");    // Possibly return null?
        //}

        /* Calculate the length of the body */
        //int length = 0;
        //for(String name : blocks) {
        //    PacketBlock block = packet.getPacketBlock(name);
        //    length += block.getLength();
        //}

        /* Calculate the length of the header */
        //int headerLength = 1;                                                       // Include the opcode
        //headerLength += getLengthForPacketSize(descriptor.getSize());

        /* Allocate the byte buffer */
        //ByteBuffer buffer = ByteBuffer.allocate(headerLength + length);

        /* Put the opcode of the packet */
        //int opcode = descriptor.getOpcode();

        /* Spoof the opcode of the packet if required */
        //if(state.useCipher()) {

            /* Check to make sure the cipher is not null */
        //    ISAACCipher cipher = state.getCipher();
        //    if(cipher == null) {
        //        throw new IllegalStateException("cipher cannot be null");
        //    }

            /* Add the next value to the opcode */
        //    opcode += cipher.getNextValue();
        //}

        //buffer.put((byte) descriptor.getOpcode());

        /* Encode the size of the packet into the buffer */
        //int size = descriptor.getSize();
        //if(size < 0) {
        //    if(size == VAR_SHORT) {
        //        buffer.putShort((short) length);
        //    } else {
        //        buffer.put((byte) length);
        //    }
        //}

        /* Encode each of the blocks into the buffer */
        //for(String name : blocks) {
        //    PacketBlock block = packet.getPacketBlock(name);

            /* Check if there is a transformer for a block and transform the block if needed */
        //    if(transformers.containsKey(name)) {
        //        block.encodeValue(transformers.get(name));
        //    }
        //
        //    block.encode(buffer);
        //}

        //return buffer;

        return null;
    }

    /**
     * Gets the length of a packet size.
     *
     * @param size  The packet size to get the length for.
     * @return      The length for the provided packet size.
     */
    private static int getLengthForPacketSize(int size) {
        //switch(size) {
        //
        //    case VAR_BYTE:
        //        return 1;
        //
        //    case VAR_SHORT:
        //        return 2;
        //
        //    default:
        //        throw new RuntimeException("Unhandled packet size");
        //}

        return -1;
    }
}
