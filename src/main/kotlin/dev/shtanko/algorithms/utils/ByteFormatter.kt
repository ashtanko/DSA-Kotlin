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

package dev.shtanko.algorithms.utils

import dev.shtanko.algorithms.BIN_FORMAT
import dev.shtanko.algorithms.SI_FORMAT
import java.util.Locale

/**
 * Implementation of ByteFormatter for formatting byte values in binary format.
 */
val binByteFormatter = ByteFormatter { bytes, current ->
    String.format(Locale.getDefault(), BIN_FORMAT, bytes, current)
}

/**
 * Implementation of ByteFormatter for formatting byte values in SI format.
 */
val siByteFormatter = ByteFormatter { bytes, current ->
    String.format(Locale.getDefault(), SI_FORMAT, bytes, current)
}

/**
 * Functional interface for formatting byte values.
 */
fun interface ByteFormatter {
    /**
     * Formats the given bytes using the specified current unit.
     *
     * @param bytes the number of bytes to be formatted.
     * @param current the unit of the current byte value (e.g., 'B' for bytes, 'iB' for binary bytes).
     * @return a formatted string representing the byte value.
     */
    operator fun invoke(bytes: Double, current: Char): String
}
