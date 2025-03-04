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
 * Computes the factorial of the given input using tail recursion.
 * Factorial, in mathematics, the product of all positive integers less than or equal to a given positive integer
 * and denoted by that integer and an exclamation point. Thus, factorial seven is written 7!,
 * meaning 1 × 2 × 3 × 4 × 5 × 6 × 7. Factorial zero is defined as equal to 1.
 *
 * @param input The input number to compute the factorial of.
 * @param temp The temporary variable to store the intermediate result (default: 1).
 * @return The factorial of the input number.
 * @throws IllegalArgumentException if the input is a negative number.
 */
tailrec fun computeFactorial(
    input: Int,
    temp: Long = 1L,
): Long =
    when {
        input < 0 -> error("Factorial is not defined for negative numbers")
        input == 0 -> temp
        else -> computeFactorial(input - 1, temp * input)
    }
