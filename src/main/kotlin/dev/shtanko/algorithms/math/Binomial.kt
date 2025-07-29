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

package dev.shtanko.algorithms.math

/**
 * Calculates the binomial coefficient (n choose k).
 * A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.
 * A binomial coefficient C(n, k) also gives the number of ways, disregarding order,
 * that k objects can be chosen from among n objects; more formally, the number of k-element subsets
 * (or k-combinations) of an n-element set.
 *
 * @param totalItems The total number of items.
 * @param itemsToSelect The number of items to choose.
 * @return The binomial coefficient.
 */
fun binomial(
    totalItems: Int,
    itemsToSelect: Int,
): Long {
    var numerator = totalItems - itemsToSelect + 1
    var result = 1L
    for (denominator in 1..itemsToSelect) {
        result = result * numerator / denominator
        numerator++
    }
    return result
}
