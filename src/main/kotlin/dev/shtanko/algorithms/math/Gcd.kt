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
 * Calculates the greatest common divisor (GCD) of the two integers in the Pair.
 *
 * @receiver The Pair of integers.
 * @return The greatest common divisor of the two integers.
 */
fun Pair<Int, Int>.gcd(): Int {
    var largerNumber = first
    var smallerNumber = second
    while (smallerNumber != 0) {
        val remainder = largerNumber % smallerNumber
        largerNumber = smallerNumber
        smallerNumber = remainder
    }
    return largerNumber
}

/**
 * Calculates the greatest common divisor (GCD) of two integers.
 *
 * @param number1 The first integer.
 * @param number2 The second integer.
 * @return The greatest common divisor of the two integers.
 */
fun gcd(
    number1: Int,
    number2: Int
): Int = if (number2 == 0) number1 else gcd(number2, number1 % number2)
