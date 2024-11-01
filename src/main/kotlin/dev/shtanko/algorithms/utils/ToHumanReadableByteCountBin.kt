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

import dev.shtanko.algorithms.BYTE
import dev.shtanko.algorithms.DECIMAL
import java.text.CharacterIterator
import java.text.StringCharacterIterator
import java.util.Locale
import kotlin.math.abs

// Bit mask used to determine the maximum value for byte conversion
private const val BIT_MASK = 0xf_ffc_ccc_ccc_ccc_ccL
private const val MAX_LOOP_INDEX = 40
private const val UNITS = "KMGTPE"

/**
 * Converts a long value to a human-readable byte count representation using
 * binary prefixes.
 *
 * @param formatter The formatter to use for converting the byte count to a
 * string representation.
 *                  Defaults to `siByteFormatter`.
 * @return The human-readable byte count representation.
 */
fun Long.toHumanReadableByteCountBin(formatter: ByteFormatter = siByteFormatter): String {
    val bytes = this
    val absBytes = if (bytes == Long.MIN_VALUE) Long.MAX_VALUE else abs(bytes)
    if (absBytes < BYTE) {
        return String.format(Locale.getDefault(), "%d B", bytes)
    }
    var value = absBytes
    val ci: CharacterIterator = StringCharacterIterator(UNITS)
    var i = MAX_LOOP_INDEX
    while (i >= 0 && absBytes > BIT_MASK shr i) {
        value = value shr DECIMAL
        ci.next()
        i -= DECIMAL
    }
    value *= java.lang.Long.signum(bytes)
        .toLong()
    val kiloBytes = value / BYTE.toDouble()
    val current = ci.current()

    return formatter.invoke(kiloBytes, current)
}
