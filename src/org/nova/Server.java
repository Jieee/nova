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

package org.nova;

import java.util.logging.Logger;

/**
 * Created by Hadyn Richard
 */
public final class Server {

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    /**
     * The command line arguments.
     * 
     * @param args  The command line arguments.
     */
    public static void main(String[] args) {
        System.err.println("`7MN.   `7MF'                                                              \n" +
                           "  MMN.    M                                                                \n" +
                           "  M YMb   M  ,pW\"Wq.`7M'   `MF',6\"Yb.  Created by Hadyn Richard aka Sini \n" +
                           "  M  `MN. M 6W'   `Wb VA   ,V 8)   MM  Thanks to: Trey, Runelocus, PRS06   \n" +
                           "  M   `MM.M 8M     M8  VA ,V   ,pm9MM                                      \n" +
                           "  M     YMM YA.   ,A9   VVV   8M   MM                                      \n" +
                           ".JML.    YM  `Ybmd9'     W    `Moo9^Yo.                                    \n" +
                           "-----------------------------------------------------------------------------");
    
        logger.info("Starting up...");

        logger.info("Finished loading!");
    }
}
