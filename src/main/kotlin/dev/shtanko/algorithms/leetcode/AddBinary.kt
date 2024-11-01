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

package dev.shtanko.algorithms.leetcode

import java.math.BigInteger

/**
 * 67. Add Binary
 * @see <a href="https://leetcode.com/problems/add-binary">Source</a>
 */
fun interface AddBinary {
    /**
     * Adds two binary strings and returns their sum as a binary string.
     *
     * @param left The first binary string.
     * @param right The second binary string.
     * @return The sum of the two binary strings as a binary string.
     */
    operator fun invoke(left: String, right: String): String
}

/**
 * # Approach 1: Bit by BitComputation
 *
 * # Intuition
 * The problem is to add two binary strings. This can be approached in a manner
 * similar to how we add two decimal numbers, but instead, we work with binary
 * numbers. The key is to handle the binary digits (bits) from right to left,
 * managing the carry at each step just as we do in base-10 addition.
 *
 * # Approach
 * We use two pointers starting at the end of both binary strings and move
 * towards the beginning. At each step, we calculate the sum of the
 * corresponding bits along with the carry from the previous step. The sum of
 * two bits can be 0, 1, or 2 (where 2 in binary is 10, so we have a carry of 1)
 * We append the result bit to a StringBuilder and update the carry. If one
 * string is longer than the other, the excess bits are added directly to the
 * result. Finally, if there's a carry left after the main loop, it's appended
 * to the result as well. The result string is then reversed to get the correct
 * binary sum.
 *
 * # Complexity
 * - Time complexity: O(max(n, m))
 * The time complexity is linear with respect to the length of the longer
 * binary string, since we process each bit exactly once.
 *
 * - Space complexity: O(max(n, m))
 * The space complexity is also linear with respect to the length of the longer
 * binary string. This accounts for the space used by the StringBuilder to store
 * the result.
 */
val addBinaryBitByBitComputation = AddBinary { left: String, right: String ->
    val resultBuilder = StringBuilder()
    var leftIndex = left.lastIndex
    var rightIndex = right.lastIndex
    var carry = 0
    while (leftIndex >= 0 || rightIndex >= 0) {
        var sum = carry
        if (rightIndex >= 0) {
            sum += right[rightIndex--] - '0'
        }
        if (leftIndex >= 0) {
            sum += left[leftIndex--] - '0'
        }
        resultBuilder.append(sum % 2)
        carry = sum / 2
    }
    if (carry != 0) {
        resultBuilder.append(carry)
    }
    resultBuilder.reverse().toString()
}

/**
 * # Approach 2: Bit Manipulation
 *
 * # Intuition
 * Adding two binary numbers can be efficiently handled using bit manipulation
 * techniques. Instead of performing bit-by-bit addition manually, we can
 * leverage the properties of bitwise operations to simplify the process.
 * This approach is inspired by how binary addition works at the hardware level.
 *
 * # Approach
 * We use the properties of `XOR` and `AND` bitwise operations to perform binary
 * addition. The `XOR` operation helps us find the sum without considering the
 * carry, while the `AND` operation helps us determine where the carry bits are.
 * By repeatedly performing these operations and shifting the carry left until
 * there are no more carry bits, we can obtain the final binary sum.
 *
 * 1. Convert the binary strings to `BigInteger` to handle large binary numbers.
 * 2. Use a loop to repeatedly apply the `XOR` and `AND` operations:
 *    - `firstNum.xor(secondNum)` gives the sum without carry.
 *    - `firstNum.and(secondNum).shiftLeft(1)` gives the carry.
 *    - Update `firstNum` to the result of `XOR` and `secondNum` to the carry.
 * 3. Continue the loop until `secondNum` (the carry) is zero.
 * 4. Convert the result back to a binary string.
 *
 * Special cases:
 * - If one of the inputs is blank, return the non-blank input.
 * - If both inputs are blank, return an empty string.
 *
 * # Complexity
 * - Time complexity: O(max(n, m))
 * The time complexity depends on the length of the binary strings, as each bit
 * must be processed. The loop runs for the number of bits in the longer string.
 *
 * - Space complexity: O(max(n, m))
 * The space complexity depends on the storage required for the `BigInteger`
 * representations of the binary strings, which is proportional to the number
 * of bits in the longer string.
 */
val addBinaryBitManipulation = AddBinary { left: String, right: String ->
    when {
        left.isBlank() && right.isNotBlank() -> right
        left.isNotBlank() && right.isBlank() -> left
        left.isBlank() && right.isBlank() -> ""
        else -> {
            var firstNumber = BigInteger(left, 2)
            var secondNumber = BigInteger(right, 2)
            val zero = BigInteger.ZERO
            var carry: BigInteger
            var sum: BigInteger
            while (secondNumber != zero) {
                sum = firstNumber.xor(secondNumber)
                carry = firstNumber.and(secondNumber).shiftLeft(1)
                firstNumber = sum
                secondNumber = carry
            }
            firstNumber.toString(2)
        }
    }
}
