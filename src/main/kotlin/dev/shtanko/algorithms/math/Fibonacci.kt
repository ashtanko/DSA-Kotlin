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
 * Enum class representing different strategies for calculating Fibonacci numbers.
 */
enum class Fibonacci {
    ITERATIVE {
        override fun invoke(index: Long): Long =
            if (index < 2) {
                index
            } else {
                var previous = 0L
                var current = 1L
                var remainingSteps = index
                do {
                    val sum = previous + current
                    previous = current
                    current = sum
                } while (remainingSteps-- > 1)
                previous
            }
    },
    RECURSIVE {
        override fun invoke(index: Long): Long = if (index < 2) {
            index
        } else {
            this(index - 1) + this(index - 2)
        }
    };

    /**
     * Calculates the Fibonacci number at the given index using the specified strategy.
     *
     * @param index The index of the Fibonacci number.
     * @return The Fibonacci number at the given index.
     */
    abstract operator fun invoke(index: Long): Long
}

/**
 * Calculates the Fibonacci number at the given index using recursion.
 *
 * @receiver The index of the Fibonacci number.
 * @return The Fibonacci number at the given index.
 */
fun Int.toFibonacciSequence(): Int {
    if (this <= 1) {
        return this
    }
    return (this - 1).toFibonacciSequence() + (this - 2).toFibonacciSequence()
}

/**
 * Calculates the Fibonacci number at the given index using iteration.
 *
 * @param num The index of the Fibonacci number.
 * @return The Fibonacci number at the given index.
 */
fun fibonacciAt(num: Int) =
    run {
        tailrec fun fibonacciAcc(
            count: Int,
            prev: Long,
            curr: Long,
        ): Long = when (count == 0) {
            true -> curr
            false -> fibonacciAcc(count - 1, prev + curr, prev)
        }
        fibonacciAcc(num, 1, 0)
    }
