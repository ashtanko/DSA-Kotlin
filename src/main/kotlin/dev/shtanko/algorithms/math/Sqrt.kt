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

import dev.shtanko.algorithms.EPSILON
import kotlin.math.abs

/**
 * Calculates the square root of the given integer.
 *
 * @param number The integer to calculate the square root of.
 * @param tolerance The tolerance value for convergence (default: EPSILON).
 * @return The square root of the given integer.
 */
fun sqrt(
    number: Int,
    tolerance: Double = EPSILON,
): Double = sqrt(number.toDouble(), tolerance)

/**
 * Calculates the square root of the given double.
 *
 * @param number The double to calculate the square root of.
 * @param tolerance The tolerance value for convergence (default: EPSILON).
 * @return The square root of the given double.
 */
fun sqrt(
    number: Double,
    tolerance: Double = EPSILON,
): Double {
    if (number < 0) {
        return Double.NaN
    }
    var approximation = number
    while (abs(approximation - number / approximation) > tolerance * approximation) {
        approximation = (number / approximation + approximation) / 2
    }
    return approximation
}
