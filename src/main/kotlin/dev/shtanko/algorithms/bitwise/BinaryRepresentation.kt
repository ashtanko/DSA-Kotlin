/*
 * MIT License

 * Copyright (c) 2022 Oleksii Shtanko

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
*/

package dev.shtanko.algorithms.bitwise

private const val BITS_COUNT = 32

/**
 * Converts a 32-bit unsigned integer to its binary representation.
 *
 * The method takes a 32-bit unsigned integer and returns its binary
 * representation as a string.
 * It starts from the most significant bit (bit 31) and iterates through each
 * bit, appending "1" if the bit is ON (1), or "0" if the bit is OFF (0).
 * The resulting binary representation is returned as a string.
 *
 * Time Complexity: O(1)
 * Auxiliary Space: O(1)
 *
 * @return The binary representation of the unsigned integer as a string.
 */
fun Long.bin(): String {
    val sb = StringBuilder()
    sb.append("0")

    val mostSignificantBit = BITS_COUNT - 2
    // Create the initial bitmask with a 1 at the most significant bit position
    val initialBitMask = 1L shl mostSignificantBit

    var currentBitMask: Long = initialBitMask
    while (currentBitMask > 0) {
        // Check if the current bit is set (1) or not (0)
        if (this and currentBitMask != 0L) {
            sb.append("1")
        } else {
            sb.append("0")
        }
        // Shift the bitmask to the right to check the next bit
        currentBitMask /= 2
    }
    return sb.toString()
}
