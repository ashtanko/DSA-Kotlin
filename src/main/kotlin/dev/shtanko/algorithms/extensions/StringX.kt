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

import kotlin.math.min

private val alphabet =
    charArrayOf(
        'a', 'b', 'c', 'd',
        'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l',
        'm', 'n', 'o', 'p',
        'q', 'r', 's', 't',
        'u', 'v', 'w', 'x',
        'y', 'z',
    )

/**
 * Checks if a String represents a binary number (contains only '0' and '1' characters).
 *
 * @return `true` if the String represents a binary number, `false` otherwise.
 */
fun String.isBinary(): Boolean {
    if (this.isBlank()) {
        return false
    }
    val set = toSet().toMutableSet().apply {
        removeAll(listOf('0', '1'))
    }
    return set.isEmpty()
}

/**
 * Finds the common prefix of two Strings in a Pair.
 *
 * @return The common prefix String.
 */
fun Pair<String, String>.commonPrefix(): String {
    val (left, right) = this
    val min = min(left.length, right.length)
    for (i in 0 until min) {
        if (left[i] != right[i]) {
            return left.substring(0, i)
        }
    }
    return left.substring(0, min)
}

/**
 * Counts the number of occurrences of '0' and '1' characters in a String.
 *
 * @return An IntArray with the count of '0's and '1's respectively.
 */
fun String.countZeroesOnes(): IntArray {
    val counts = IntArray(2)
    for (char in this) {
        counts[char - '0']++
    }
    return counts
}

/**
 * Gets the number representation of a String based on the position of each character in the alphabet.
 *
 * @return The number representation of the String.
 */
fun String.getNumberOfLetter(): Int {
    val sb = StringBuilder()
    for (char in this) {
        sb.append("${alphabet.indexOf(char)}")
    }
    return sb.toString().removeZeroesInBegin().toInt()
}

/**
 * Removes leading zeroes from a String, preserving a single '0' if the String contains all zeroes.
 *
 * @return The modified String without leading zeroes.
 */
fun String.removeZeroesInBegin(): String {
    return when {
        isEmpty() -> ""
        length == 1 && this == "0" -> this
        isFirstZero().not() -> this
        isAllZeroes() -> "0"
        else -> return this.toInt().toString()
    }
}

/**
 * Checks if a String consists of all zeroes.
 *
 * @return `true` if the String consists of all zeroes, `false` otherwise.
 */
fun String.isAllZeroes(): Boolean = this.none { it.isZero().not() }

/**
 * Checks if the first character of the String is '0'.
 *
 * @return `true` if the first character is '0', `false` otherwise.
 */
fun String.isFirstZero(): Boolean = if (isEmpty()) {
    false
} else {
    this.first().isZero()
}

/**
 * Checks if a Char is equal to '0'.
 *
 * @return `true` if the Char is '0', `false` otherwise.
 */
fun Char.isZero(): Boolean = this == '0'
