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

import dev.shtanko.algorithms.ALPHABET_LETTERS_COUNT

/**
 * # Intuition
 * The problem is to calculate the sum of the appeal of all substrings of a
 * given string. The appeal of a string is defined as the number of distinct
 * characters in it. The challenge is to efficiently compute this for all
 * substrings.
 *
 * # Approach
 * We can use dynamic programming to solve this problem. The key idea is to keep
 * track of the last position where each character appeared. For each character
 * in the string, we can calculate the contribution to the total appeal based on
 * its position and the previous positions of the same character. We maintain an
 * array `prev` where `prev[char - 'a']` keeps the last index of character
 * `char`. For each character at index `i`, the contribution to the appeal
 * is calculated as `i + 1 - prev[char - 'a']`. We then update the `prev` array
 * with the current index.
 *
 * # Complexity
 * - Time complexity: O(n)
 * The time complexity is linear with respect to the length of the string, since
 * we process each character exactly once.
 *
 * - Space complexity: O(1)
 * The space complexity is constant, as we use a fixed-size array of length 26
 * to keep track of the last positions of each
 * character (assuming only lowercase English letters).
 */
val appealSumDp = AppealSum { str: String ->
    var cur: Long = 0
    val prev = LongArray(ALPHABET_LETTERS_COUNT)
    str.mapIndexed { index, char ->
        cur += index + 1 - prev[char - 'a']
        prev[char - 'a'] = index.toLong() + 1
        cur
    }.sum()
}

/**
 * 2262. Total Appeal of A String
 * @see <a href="https://leetcode.com/problems/total-appeal-of-a-string">
 *     Source</a>
 * Functional interface representing an appeal sum operation on a String.
 */
fun interface AppealSum {
    /**
     * Performs an appeal sum operation on the given String.
     *
     * @param str The input String to perform the appeal sum on.
     * @return The result of the appeal sum operation.
     */
    operator fun invoke(str: String): Long
}
