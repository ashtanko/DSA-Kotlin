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

import kotlin.math.sqrt
import kotlin.random.Random

/**
 * Functional interface representing a predicate that accepts an Int and returns a Boolean.
 */
fun interface IntPredicate {
    /**
     * Evaluates the predicate for the given Int value.
     *
     * @param i The Int value to evaluate.
     * @return `true` if the predicate accepts the value, `false` otherwise.
     */
    fun accept(i: Int): Boolean
}

/**
 * Checks if an Int value is even.
 *
 * @return `true` if the Int value is even, `false` otherwise.
 */
val isEven = IntPredicate { it % 2 == 0 }

/**
 * Checks if an Int value is even.
 *
 * @return `true` if the Int value is even, `false` otherwise.
 */
val Int.isEven: Boolean
    get() = this % 2 == 0

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
fun Int.lessThanZero(): Boolean = this < 0

/**
 * Checks if an Int value is a prime number.
 *
 * @return `true` if the Int value is a prime number, `false` otherwise.
 */
fun Int.isPrime(): Boolean {
    if (this < 2) {
        return false
    }
    val r = sqrt(this.toDouble()).toInt()
    for (d in 2..r) {
        if (this % d == 0) {
            return false
        }
    }
    return true
}
