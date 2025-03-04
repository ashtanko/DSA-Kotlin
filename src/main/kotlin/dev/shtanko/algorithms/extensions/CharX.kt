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

package dev.shtanko.algorithms.extensions

import kotlin.random.Random

/**
 * Generates a random string of the specified length consisting of characters within the closed range.
 *
 * @param length the length of the generated random string.
 * @return a random string of the specified length.
 */
fun ClosedRange<Char>.randomString(length: Int) =
    (1..length)
        .map {
            val randomLimit = endInclusive.code - start.code
            val randomCode = Random.nextInt(until = randomLimit) + start.code
            randomCode.toChar()
        }
        .joinToString("")

/**
 * Checks if the character is a vowel (a, e, i, o, u).
 *
 * @return true if the character is a vowel, false otherwise.
 */
fun Char.isVowel(): Boolean {
    val ae = this == 'a' || this == 'e'
    val io = this == 'i' || this == 'o'
    val iou = io || this == 'u'
    return ae || iou
}
