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

import dev.shtanko.algorithms.MILLISECOND
import java.util.concurrent.TimeUnit

/**
 * Converts the given duration in nanoseconds to a human-readable format.
 *
 * @return a string representing the duration in a human-readable format.
 */
fun Long.toHumanReadableDuration(): String {
    val millis = TimeUnit.MILLISECONDS.convert(this, TimeUnit.NANOSECONDS)
    val sec = TimeUnit.SECONDS.convert(this, TimeUnit.NANOSECONDS)
    val sb =
        if (sec != 0L) {
            val diff = millis - MILLISECOND * sec
            val sbDiff = "$diff ms"
            "$sec,$sbDiff"
        } else {
            "$millis ms"
        }
    return "Runtime: $sb"
}
