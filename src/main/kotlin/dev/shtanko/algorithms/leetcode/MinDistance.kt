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

import kotlin.math.max
import kotlin.math.min

/**
 * # Approach #1 Using Longest Common Subsequence
 *
 * # Intuition
 * The problem of finding the minimum number of operations required to convert
 * one string into another can be related to finding the longest common
 * subsequence (LCS) of the two strings. The fewer characters the two strings
 * have in common, the more operations (insertions and deletions) are required
 * to make them identical.
 *
 * # Approach
 * To solve this problem, we can use the concept of the longest common
 * subsequence (LCS). The idea is that the characters in the LCS do not need to
 * be changed. Therefore, the minimum number of operations required will be the
 * total number of characters in both strings minus twice the number of
 * characters in the LCS.
 *
 * The approach involves:
 * 1. Implementing a recursive function to find the length of the LCS of the two
 * strings. This function compares characters from the end of both strings and
 * reduces the problem size by either including the current character in the LCS
 * or skipping it in one of the strings.
 * 2. Calculating the minimum number of operations as the sum of the lengths of
 * both strings minus twice the length of the LCS.
 *
 * # Complexity
 * - Time complexity: O(2^(n + m))
 * The time complexity of the recursive LCS solution is exponential due to the
 * overlapping sub-problems and lack of memoization. For each character in the
 * first string, we consider two possibilities for each character in the second
 * string.
 *
 * - Space complexity: O(n + m)
 * The space complexity is linear in terms of the call stack used by the
 * recursion, where `n` and `m` are the lengths of the two strings.
 */
val minDistanceLcs = MinDistance { firstWord: String, targetWord: String ->

    /**
     * Calculates the length of the longest common subsequence (LCS) between
     * two strings.
     *
     * @param firstWord The first string.
     * @param secondWord The second string.
     * @param firstWordLen The length of the first string.
     * @param secondWordLen The length of the second string.
     * @return The length of the LCS.
     */
    fun calculateLcsLength(
        firstWord: String,
        secondWord: String,
        firstWordLen: Int,
        secondWordLen: Int,
    ): Int {
        if (firstWordLen == 0 || secondWordLen == 0) {
            return 0
        }
        return if (firstWord[firstWordLen - 1] == secondWord[secondWordLen - 1]) {
            1 + calculateLcsLength(firstWord, secondWord, firstWordLen - 1, secondWordLen - 1)
        } else {
            max(
                calculateLcsLength(firstWord, secondWord, firstWordLen, secondWordLen - 1),
                calculateLcsLength(firstWord, secondWord, firstWordLen - 1, secondWordLen),
            )
        }
    }

    return@MinDistance firstWord.length + targetWord.length - 2 * calculateLcsLength(
        firstWord,
        targetWord,
        firstWord.length,
        targetWord.length,
    )
}

/**
 * # Approach #2 Longest Common Subsequence with Memoization
 *
 * # Intuition
 * The problem of finding the minimum number of operations required to convert
 * one string into another can be efficiently solved using the longest common
 * subsequence (LCS) approach. By identifying the LCS, we can determine the
 * minimal changes needed because the LCS represents the portion of the strings
 * that are already aligned.
 *
 * # Approach
 * To find the minimum number of operations, we use dynamic programming with
 * memoization to compute the length of the longest common subsequence (LCS).
 * The steps are as follows:
 *
 * 1. Define a recursive function `longestCommonSubsequenceLength` that takes
 * the two words, their current lengths, and a memoization array.
 * 2. If either string length is zero, return 0 (base case).
 * 3. If the current subproblem has been solved before
 * (i.e., memo[length1][length2] > 0), return the cached value.
 * 4. If the current characters of both strings match, add 1 to the LCS length
 * of the remaining substrings.
 * 5. If the current characters do not match, take the maximum LCS length by
 * either excluding the current character of `word1` or `word2`.
 * 6. Store the result in the memoization array to avoid redundant computations.
 * 7. The minimum number of operations is then calculated as the sum of the
 * lengths of both strings minus twice the LCS length.
 *
 * # Complexity
 * - Time complexity: O(n * m)
 * The time complexity is polynomial, as each sub-problem is solved once and
 * stored in the memoization array, where `n` and `m` are the lengths of the two
 * strings.
 *
 * - Space complexity: O(n * m)
 * The space complexity is also polynomial due to the memoization array that
 * stores the LCS lengths for all sub-problems.
 */
val minDistanceLcsMemo = MinDistance { sourceWord: String, targetWord: String ->

    /**
     * Calculates the length of the longest common subsequence (LCS) between
     * two strings using memoization.
     *
     * @param sourceWord The first string.
     * @param targetWord The second string.
     * @param length1 The length of the first string.
     * @param length2 The length of the second string.
     * @param memo The memoization array.
     * @return The length of the LCS.
     */
    fun longestCommonSubsequenceLength(
        sourceWord: String,
        targetWord: String,
        length1: Int,
        length2: Int,
        memo: Array<IntArray>,
    ): Int {
        if (length1 == 0 || length2 == 0) {
            return 0
        }
        if (memo[length1][length2] > 0) {
            return memo[length1][length2]
        }
        if (sourceWord[length1 - 1] == targetWord[length2 - 1]) {
            memo[length1][length2] = 1 + longestCommonSubsequenceLength(
                sourceWord,
                targetWord,
                length1 - 1,
                length2 - 1,
                memo,
            )
        } else {
            memo[length1][length2] = max(
                longestCommonSubsequenceLength(sourceWord, targetWord, length1, length2 - 1, memo),
                longestCommonSubsequenceLength(sourceWord, targetWord, length1 - 1, length2, memo),
            )
        }
        return memo[length1][length2]
    }

    val memo =
        Array(sourceWord.length + 1) {
            IntArray(
                targetWord.length + 1,
            )
        }
    return@MinDistance sourceWord.length + targetWord.length - 2 * longestCommonSubsequenceLength(
        sourceWord,
        targetWord,
        sourceWord.length,
        targetWord.length,
        memo,
    )
}

/**
 * #Approach #3 Using Longest Common Subsequence- Dynamic Programming
 *
 * # Intuition
 * To convert one string into another with the minimum number of operations,
 * we can leverage the concept of the longest common subsequence (LCS). The LCS
 * helps identify the longest sequence of characters that appear in both strings
 * in the same order. The minimal number of operations required will be the
 * total number of characters in both strings minus twice the number of
 * characters in the LCS.
 *
 * # Approach
 * We use dynamic programming to efficiently calculate the length of the longest
 * common subsequence (LCS). We define a 2D array `dp` where `dp[i][j]`
 * represents the length of the LCS of the substrings
 * `word1[0..i-1]` and `word2[0..j-1]`. The approach involves:
 *
 * 1. Initializing a 2D array `dp` with dimensions
 * `(word1.length + 1) x (word2.length + 1)` to store the LCS lengths.
 * 2. Iterating over each character in both strings. If characters match,
 * the value is updated as `dp[i][j] = 1 + dp[i - 1][j - 1]`. If they do not
 * match, we take the maximum value from the previous sub-problems:
 * `dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])`.
 * 3. The final LCS length will be found at `dp[word1.length][word2.length]`.
 * 4. The minimum number of operations required to make the strings identical is
 * calculated as the sum of the lengths of both strings minus twice the LCS
 * length.
 *
 * # Complexity
 * - Time complexity: O(n * m)
 * The time complexity is polynomial, where `n` and `m` are the lengths of the
 * two strings. We fill an `n x m` table, and each cell is computed in constant
 * time.
 *
 * - Space complexity: O(n * m)
 * The space complexity is also polynomial due to the 2D array used to store the
 * LCS lengths for all sub-problems.
 */
val minDistanceLcsDp = MinDistance { sourceWord: String, targetWord: String ->
    val dp = Array(sourceWord.length + 1) { IntArray(targetWord.length + 1) }
    for (i in 0..sourceWord.length) {
        for (j in 0..targetWord.length) {
            if (i == 0 || j == 0) {
                continue
            }
            if (sourceWord[i - 1] == targetWord[j - 1]) {
                dp[i][j] = 1 + dp[i - 1][j - 1]
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    sourceWord.length + targetWord.length - 2 * dp[sourceWord.length][targetWord.length]
}

/**
 * # Approach #4 Without using LCS Dynamic Programming
 * # Intuition
 * The problem is to find the minimum number of operations required to convert
 * one string into another. The allowed operations are insertions and deletions.
 * This problem can be approached using dynamic programming to build a solution
 * incrementally based on smaller subproblems.
 *
 * # Approach
 * We define a 2D array `dp` where `dp[i][j]` represents the minimum number of
 * operations required to convert the substring `word1[0..i-1]` to the substring
 * `word2[0..j-1]`. The approach involves:
 *
 * 1. Initializing the base cases:
 *    - `dp[i][0] = i` for all `i` because converting any prefix of `word1` to
 *    an empty string requires `i` deletions.
 *    - `dp[0][j] = j` for all `j` because converting an empty string to any
 *    prefix of `word2` requires `j` insertions.
 * 2. Iterating through the characters of both strings and filling in the
 * `dp` array:
 *    - If `word1[i - 1] == word2[j - 1]`, no new operations are needed, so
 *    `dp[i][j] = dp[i - 1][j - 1]`.
 *    - Otherwise, `dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1])`, where we
 *    consider the cost of either deleting from `word1` or inserting
 *    into `word2`.
 * 3. The final answer is found in `dp[word1.length][word2.length]`,
 * representing the minimum number of operations to convert the entirety of
 * `word1` to `word2`.
 *
 * # Complexity
 * - Time complexity: O(n * m)
 * The time complexity is polynomial, where `n` and `m` are the lengths of the
 * two strings. We fill an `n x m` table, and each cell is computed in constant
 * time.
 *
 * - Space complexity: O(n * m)
 * The space complexity is also polynomial due to the 2D array used to store the
 * minimum number of operations for all sub-problems.
 */
val minDistanceDp = MinDistance { sourceWord: String, targetWord: String ->
    val editDistanceMatrix =
        Array(sourceWord.length + 1) {
            IntArray(targetWord.length + 1)
        }
    for (i in 0..sourceWord.length) {
        for (j in 0..targetWord.length) {
            if (i == 0 || j == 0) {
                editDistanceMatrix[i][j] = i + j
            } else if (sourceWord[i - 1] == targetWord[j - 1]) {
                editDistanceMatrix[i][j] = editDistanceMatrix[i - 1][j - 1]
            } else {
                editDistanceMatrix[i][j] = 1 + min(editDistanceMatrix[i - 1][j], editDistanceMatrix[i][j - 1])
            }
        }
    }
    editDistanceMatrix[sourceWord.length][targetWord.length]
}

/**
 * #Approach #5 1-D Dynamic Programming
 *
 * # Intuition
 * The problem of finding the minimum number of operations to convert one string
 * into another can be optimized in terms of space complexity by using a 1D
 * array instead of a 2D array for dynamic programming. This leverages the fact
 * that we only need the current and previous rows of the DP table to compute
 * the result.
 *
 * # Approach
 * We use a dynamic programming approach with a 1D array `dp` to keep track of
 * the minimum number of operations needed to convert substrings of `word1` and
 * `word2`. The approach involves:
 *
 * 1. Initializing a 1D array `dp` of size `word2.length + 1` where `dp[j]`
 * represents the minimum number of operations required to convert the prefix
 * of `word1` to the prefix of `word2[0..j-1]`.
 * 2. Iterating through each character of `word1` and updating the `dp` array
 * for each character of `word2`:
 *    - Use a temporary array `temp` to store the current row of the DP table.
 *    - If either index `i` or `j` is zero, initialize `temp[j]` with `i + j`,
 *    representing the base cases.
 *    - If `word1[i - 1]` matches `word2[j - 1]`, set `temp[j] = dp[j - 1]`.
 *    - Otherwise, set `temp[j] = 1 + min(dp[j], temp[j - 1])` to consider the
 *    cost of either deleting from `word1` or inserting into `word2`.
 * 3. After processing each character of `word1`, update `dp` to be the current
 * row `temp`.
 * 4. The final result is found in `dp[word2.length]`, representing the minimum
 * number of operations to convert `word1` to `word2`.
 *
 * # Complexity
 * - Time complexity: O(n * m)
 * The time complexity is polynomial, where `n` and `m` are the lengths of the
 * two strings. We iterate through each character of both strings.
 *
 * - Space complexity: O(n)
 * The space complexity is linear with respect to the length of `word2`, as we
 * use a 1D array to store the current and previous rows of the DP table.
 */
val minDistance1Ddp = MinDistance { sourceWord: String, targetWord: String ->
    var dp = IntArray(targetWord.length + 1)
    for (i in 0..sourceWord.length) {
        val temp = IntArray(targetWord.length + 1)
        for (j in 0..targetWord.length) {
            if (i == 0 || j == 0) {
                temp[j] = i + j
            } else if (sourceWord[i - 1] == targetWord[j - 1]) {
                temp[j] = dp[j - 1]
            } else {
                temp[j] = 1 + min(dp[j], temp[j - 1])
            }
        }
        dp = temp
    }
    dp[targetWord.length]
}

/**
 * 583. Delete Operation for Two Strings
 * @see <a href="https://leetcode.com/problems/delete-operation-for-two-strings">Source</a>
 */
fun interface MinDistance {
    /**
     * Calculates the minimum number of operations required to convert the
     * source word
     * into the target word.
     *
     * @param sourceWord The original string to be converted.
     * @param targetWord The target string to convert to.
     * @return The minimum number of operations required for the conversion.
     */
    operator fun invoke(sourceWord: String, targetWord: String): Int
}
