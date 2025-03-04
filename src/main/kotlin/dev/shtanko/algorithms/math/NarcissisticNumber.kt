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

import dev.shtanko.algorithms.DECIMAL
import kotlin.math.pow

/**
 * Functional interface representing a narcissistic number check.
 */
fun interface NarcissisticNumber {
    /**
     * Checks whether the given number is an Armstrong number.
     *
     * @param number The number to check.
     * @return `true` if the number is an Armstrong number, `false` otherwise.
     */
    fun isArmstrong(number: Int): Boolean
}

/**
 * Implementation of the NarcissisticNumber interface.
 */
data object NarcissisticNumberImpl : NarcissisticNumber {
    /**
     * Checks whether the given number is an Armstrong number.
     *
     * @param number The number to check.
     * @return `true` if the number is an Armstrong number, `false` otherwise.
     */
    override fun isArmstrong(number: Int): Boolean {
        if (number < 0) {
            return false
        }
        var sum = 0
        var temp = number
        val totalDigits = numberOfDigits(number)
        while (temp > 0) {
            val rem = temp % DECIMAL
            sum += rem.toDouble().pow(totalDigits.toDouble()).toInt()
            temp /= DECIMAL
        }
        return number == sum
    }

    /**
     * Calculates the number of digits in the given number.
     *
     * @param num The number to calculate the number of digits for.
     * @return The number of digits in the given number.
     */
    private fun numberOfDigits(num: Int): Int {
        var res = num
        var totalDigits = 0
        while (res > 0) {
            res /= DECIMAL
            totalDigits++
        }
        return totalDigits
    }
}
