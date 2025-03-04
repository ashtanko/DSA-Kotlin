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

package dev.shtanko.algorithms.sorts

/**
 * Checks if the integer array is sorted in non-decreasing order.
 *
 * This function uses a sequence to compare each element with the next one
 * and ensures that all elements are in non-decreasing order.
 *
 * @return `true` if the array is sorted in non-decreasing order, `false`
 * otherwise.
 */
fun IntArray.isSorted(): Boolean =
    asSequence().zipWithNext { a, b -> a <= b }.all { it }

/**
 * Checks if the array of integers is sorted in non-decreasing order.
 *
 * This function uses a sequence to compare each element with the next one
 * and ensures that all elements are in non-decreasing order.
 *
 * @return `true` if the array is sorted in non-decreasing order, `false`
 * otherwise.
 */
@Suppress("ArrayPrimitive")
fun Array<Int>.isSorted(): Boolean =
    asSequence().zipWithNext { a, b -> a <= b }.all { it }
