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

import java.text.CharacterIterator
import java.text.StringCharacterIterator

private const val LIMIT = 1000
private const val BOUNDARY = 999_950
private const val UNITS = "kMGTPE"

/**
 * Converts a long value to a human-readable byte count representation using
 * SI prefixes.
 *
 * @param formatter The formatter to use for converting the byte count to a
 * string representation.
 *                  Defaults to `binByteFormatter`.
 * @return The human-readable byte count representation.
 */
fun Long.toHumanReadableByteCountSi(formatter: ByteFormatter = binByteFormatter): String {
    var bytes = this

    if (-LIMIT < bytes && bytes < LIMIT) {
        return "$bytes B"
    }

    val ci: CharacterIterator = StringCharacterIterator(UNITS)
    while (bytes <= -BOUNDARY || bytes >= BOUNDARY) {
        bytes /= LIMIT
        ci.next()
    }
    val kiloBytes = bytes / LIMIT.toDouble()
    val current = ci.current()

    return formatter.invoke(kiloBytes, current)
}
