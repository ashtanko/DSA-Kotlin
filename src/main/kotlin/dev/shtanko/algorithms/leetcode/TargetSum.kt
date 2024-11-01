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

import kotlin.math.abs

/**
 * 494. Target Sum
 * @link https://leetcode.com/problems/target-sum/
 */
fun interface TargetSum {
    /**
     * Calculates the number of ways to achieve the target sum.
     *
     * @param nums The array of integers.
     * @param target The target sum to achieve.
     * @return The number of ways to assign `+` or `-` signs to each element
     * in the array
     * such that the resulting sum equals the target.
     */
    operator fun invoke(nums: IntArray, target: Int): Int
}

/**
 * # Approach 1: Brute Force
 *
 * # Intuition
 * The problem requires finding the number of ways to assign `+` or `-` signs
 * to each element in the array such that the resulting sum equals the target.
 * The brute force approach explores all possible combinations.
 *
 * # Approach
 * The approach involves a recursive function that tries both adding and
 * subtracting each number in the array:
 * 1. Start from the first element and recursively try both adding and
 * subtracting the current number to/from the sum.
 * 2. Move to the next element and repeat the process.
 * 3. If the end of the array is reached and the sum equals the target,
 * increment the count.
 * 4. The base case is when the index reaches the end of the array. If the sum
 * at this point equals the target, increment the count.
 *
 * # Complexity
 * - Time complexity: O(2^n)
 *   - Each element in the array has two possibilities (add or subtract),
 *   resulting in 2^n possible combinations.
 *
 * - Space complexity: O(n)
 *   - The maximum depth of the recursion stack is n.
 */
class TargetSumBruteForce : TargetSum {
    private var count = 0

    override fun invoke(
        nums: IntArray,
        target: Int,
    ): Int {
        calculate(nums, 0, 0, target)
        return count
    }

    private fun calculate(
        nums: IntArray,
        i: Int,
        sum: Int,
        target: Int,
    ) {
        if (i == nums.size) {
            if (sum == target) {
                count++
            }
        } else {
            calculate(nums, i + 1, sum + nums[i], target)
            calculate(nums, i + 1, sum - nums[i], target)
        }
    }
}

/**
 * # Approach 2: Recursion with Memoization
 *
 * # Intuition
 * The problem requires finding the number of ways to assign `+` or `-` signs to
 * each element in the array such that the resulting sum equals the target.
 * Using memoization helps to optimize the brute force approach by storing intermediate results.
 *
 * # Approach
 * The approach involves a recursive function that tries both adding and
 * subtracting each number in the array:
 * 1. Start from the first element and recursively try both adding and
 * subtracting the current number to/from the sum.
 * 2. Use a memoization array to store results of subproblems to avoid redundant
 * calculations.
 * 3. If the end of the array is reached and the sum equals the target, return 1
 * as a valid way is found.
 * 4. If the end of the array is reached and the sum does not equal the target,
 * return 0.
 * 5. Before returning, store the result of the current state in the memoization
 * array.
 *
 * # Complexity
 * - Time complexity: O(n * t)
 *   - The time complexity is reduced from O(2^n) to O(n * t), where `n` is the
 *   number of elements and `t` is the total sum of elements.
 *
 * - Space complexity: O(n * t)
 *   - The space complexity is due to the memoization array which stores the
 *   results of sub-problems.
 */
val targetSumMemoization = TargetSum { nums: IntArray, target: Int ->
    var total = 0

    /**
     * Recursive function to calculate the number of ways to achieve the target
     * sum.
     *
     * @param nums The array of integers.
     * @param i The current index in the array.
     * @param sum The current sum.
     * @param target The target sum to achieve.
     * @param memo The memoization array to store intermediate results.
     * @return The number of ways to achieve the target sum from the current
     * state.
     */
    fun calculate(
        nums: IntArray,
        i: Int,
        sum: Int,
        target: Int,
        memo: Array<IntArray>,
    ): Int {
        return if (i == nums.size) {
            if (sum == target) {
                1
            } else {
                0
            }
        } else {
            if (memo[i][sum + total] != Int.MIN_VALUE) {
                return memo[i][sum + total]
            }
            val add = calculate(nums, i + 1, sum + nums[i], target, memo)
            val subtract = calculate(nums, i + 1, sum - nums[i], target, memo)
            memo[i][sum + total] = add + subtract
            memo[i][sum + total]
        }
    }

    total = nums.sum()

    val memo = Array(nums.size) { IntArray(2 * total + 1) { Int.MIN_VALUE } }
    return@TargetSum calculate(nums, 0, 0, target, memo)
}

/**
 * # Approach 3: 2D Dynamic Programming
 *
 * # Intuition
 * The problem requires finding the number of ways to assign `+` or `-` signs
 * to each element in the array such that the
 * resulting sum equals the target. Using dynamic programming helps to
 * efficiently calculate the number of ways by keeping track of possible sums
 * at each step.
 *
 * # Approach
 * The approach involves using a dynamic programming table:
 * 1. Calculate the total sum of the array to determine the range of possible
 * sums.
 * 2. Initialize a DP table where `dp[i][j]` represents the number of ways to
 * achieve the sum `j - total` using the first `i` elements.
 * 3. For the first element, initialize the DP table with two possible sums
 * (adding and subtracting the first element).
 * 4. Iterate through the array, updating the DP table based on the possible
 * sums from the previous element.
 * 5. At each step, for each possible sum, update the DP table by adding the
 * current element and subtracting the current element.
 * 6. Finally, check the DP table for the number of ways to achieve the target
 * sum.
 *
 * # Complexity
 * - Time complexity: O(n * t)
 *   - The algorithm iterates through the array and updates the DP table for
 *   each possible sum, where `n` is the number of elements and `t` is the total
 *   sum of elements.
 *
 * - Space complexity: O(n * t)
 *   - The space complexity is due to the DP table which stores the results for
 *   each possible sum for each element.
 */
internal val twoPassSolution = TargetSum { nums: IntArray, target: Int ->
    val total: Int = nums.sum()
    val dp = Array(nums.size) { IntArray(2 * total + 1) }
    dp[0][nums[0] + total] = 1
    dp[0][-nums[0] + total] += 1

    for (i in 1 until nums.size) {
        for (sum in -total..total) {
            if (dp[i - 1][sum + total] > 0) {
                dp[i][sum + nums[i] + total] += dp[i - 1][sum + total]
                dp[i][sum - nums[i] + total] += dp[i - 1][sum + total]
            }
        }
    }
    if (abs(target) > total) 0 else dp[nums.size - 1][target + total]
}

/**
 * # Approach 4: 1D Dynamic Programming
 *
 * # Intuition
 * The problem requires finding the number of ways to assign `+` or `-` signs to
 * each element in the array such that the resulting sum equals the target.
 * Using dynamic programming with a space-optimized approach helps to
 * efficiently calculate the number of ways by keeping track of possible sums at
 * each step.
 *
 * # Approach
 * The approach involves using a dynamic programming array:
 * 1. Calculate the total sum of the array to determine the range of possible
 * sums.
 * 2. Initialize a DP array where `dp[j]` represents the number of ways to
 * achieve the sum `j - total` using the current element.
 * 3. For the first element, initialize the DP array with two possible
 * sums (adding and subtracting the first element).
 * 4. Iterate through the array, updating the DP array based on the possible
 * sums from the previous element.
 * 5. At each step, for each possible sum, update the DP array by adding the
 * current element and subtracting the current element.
 * 6. Finally, check the DP array for the number of ways to achieve the target
 * sum.
 *
 * # Complexity
 * - Time complexity: O(n * t)
 *   - The algorithm iterates through the array and updates the DP array for
 *   each possible sum, where `n` is the number of elements and `t` is the total
 *   sum of elements.
 *
 * - Space complexity: O(t)
 *   - The space complexity is reduced to O(t) due to the single DP array which
 *   stores the results for each possible sum at each step.
 */
internal val onePassSolution = TargetSum { nums: IntArray, target: Int ->
    val total: Int = nums.sum()
    var dp = IntArray(2 * total + 1)
    dp[nums[0] + total] = 1
    dp[-nums[0] + total] += 1

    for (i in 1 until nums.size) {
        val next = IntArray(2 * total + 1)
        for (sum in -total..total) {
            if (dp[sum + total] > 0) {
                next[sum + nums[i] + total] += dp[sum + total]
                next[sum - nums[i] + total] += dp[sum + total]
            }
        }
        dp = next
    }

    if (abs(target) > total) 0 else dp[target + total]
}
