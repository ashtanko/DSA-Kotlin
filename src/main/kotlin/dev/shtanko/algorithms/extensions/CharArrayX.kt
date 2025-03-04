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

/**
 * Reverses a portion of the CharArray between the specified indices.
 *
 * @param leftIdx The starting index (inclusive) of the portion to be reversed.
 * @param rightIdx The ending index (inclusive) of the portion to be reversed.
 */
fun CharArray.reverse(
    leftIdx: Int,
    rightIdx: Int,
) {
    var left = leftIdx
    var right = rightIdx
    while (left < right) {
        val tmp = this[left]
        this[left++] = this[right]
        this[right--] = tmp
    }
}

/**
 * Swaps the characters at the given indices in this CharArray.
 *
 * @param i the index of the first character to swap.
 * @param j the index of the second character to swap.
 */
fun CharArray.swap(
    i: Int,
    j: Int,
) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}
