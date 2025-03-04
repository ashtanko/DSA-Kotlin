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

import dev.shtanko.algorithms.DECIMAL

/**
 * Checks if a Long number is a super palindrome.
 * A super palindrome is defined as a number that remains a palindrome
 * after dividing it by 2 twice.
 *
 * @return `true` if the number is a super palindrome, `false` otherwise.
 */
fun Long.isSuperPalindrome(): Boolean {
    var currentNumber = this
    var isSuperPalindrome = false
    repeat(2) {
        isSuperPalindrome = currentNumber.isPalindrome()
        currentNumber /= 2
        if (!isSuperPalindrome) {
            return false
        }
    }
    return isSuperPalindrome
}

/**
 * Checks if a Long number is a palindrome.
 * A palindrome is a number that reads the same forward and backward.
 *
 * @return `true` if the number is a palindrome, `false` otherwise.
 */
fun Long.isPalindrome(): Boolean = this == this.reverse()

/**
 * Reverses the digits of a Long number.
 *
 * @return The reversed Long number.
 */
fun Long.reverse(): Long {
    var reversedNumber = 0L
    var currentNumber = this
    while (currentNumber > 0) {
        reversedNumber = DECIMAL * reversedNumber + currentNumber % DECIMAL
        currentNumber /= DECIMAL
    }
    return reversedNumber
}
