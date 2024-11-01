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

private const val EVEN_DIVISOR = 2

/**
 * Checks if an Int value is even.
 *
 * @return `true` if the Int value is even, `false` otherwise.
 */
val isEven = IntPredicate { it % EVEN_DIVISOR == 0 }

/**
 * Checks if an Int value is even.
 *
 * @return `true` if the Int value is even, `false` otherwise.
 */
fun Int.isEven(): Boolean = this % EVEN_DIVISOR == 0

/**
 * Generates an IntArray of the specified size with random values.
 *
 * @return The generated IntArray.
 */
fun Int.generateRandomArray(): IntArray {
    val array = IntArray(this)
    for (i in 0 until this) {
        array[i] = Random.nextInt(this)
    }
    return array
}

/**
 * Checks if an Int value is less than zero.
 *
 * @return `true` if the Int value is less than zero, `false` otherwise.
 */
fun Int.isLessThanZero(): Boolean = this < 0

/**
 * Checks if an Int value is a prime number.
 *
 * @return `true` if the Int value is a prime number, `false` otherwise.
 */
fun Int.isPrime(): Boolean {
    if (this < 2) {
        return false
    }
    val root = kotlin.math.sqrt(this.toDouble()).toInt()
    for (divisor in EVEN_DIVISOR..root) {
        if (this % divisor == 0) {
            return false
        }
    }
    return true
}
