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

/**
 * # Approach 1: Brute Force
 *
 * # Intuition
 * The problem is to find two numbers in an array that add up to a specific
 * target. A straightforward way to solve this is by checking every pair of
 * numbers to see if they sum to the target.
 *
 * # Approach
 * The brute force approach involves iterating over each element and checking it
 * against every other element to find a pair that sums to the target:
 *
 * 1. Use a nested loop where the outer loop iterates over each element `i` in
 * the array.
 * 2. The inner loop starts from `i + 1` and iterates over the remaining
 * elements `j` to check if the sum of `nums[i]` and `nums[j]` equals the target
 * 3. If such a pair is found, return their indices as an array.
 * 4. If no such pair is found after all iterations, return an empty array.
 *
 * # Complexity
 * - Time complexity: O(n^2)
 * The time complexity is quadratic because for each element, we check every
 * other element in the array.
 *
 * - Space complexity: O(1)
 * The space complexity is constant because we only use a fixed amount of
 * additional space for variables.
 */
val twoSumBruteForce = TwoSum { nums: IntArray, target: Int ->
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[j] == target - nums[i]) {
                return@TwoSum intArrayOf(i, j)
            }
        }
    }
    return@TwoSum intArrayOf()
}

/**
 * # Approach 2: Two-pass Hash Table
 *
 * # Intuition
 * The problem requires finding two numbers in an array that sum up to a given
 * target. Using a hash table allows us to efficiently track and check for the
 * required complement of each number in the array.
 *
 * # Approach
 * The approach involves two passes:
 * 1. First, we iterate through the array and store each number and its index in
 * a hash table.
 * 2. In the second pass, we iterate through the array again and for each
 * number, calculate its complement (target - number). We then check if this
 * complement exists in the hash table and ensure that it is not the same index
 * as the current number. If found, we return the indices of the current number
 * and its complement.
 *
 * # Complexity
 * - Time complexity: O(n)
 *   - The algorithm iterates through the array twice, each pass taking O(n)
 *   time.
 *
 * - Space complexity: O(n)
 *   - The hash table stores each of the n elements in the array.
 */
val twoSumTwoPassHashTable = TwoSum { nums: IntArray, target: Int ->
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        map[nums[i]] = i
    }
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement) && map[complement] != i) {
            return@TwoSum intArrayOf(i, map.getOrDefault(complement, 0))
        }
    }
    return@TwoSum intArrayOf()
}

/**
 * # Approach 3: One-pass Hash Table
 *
 * # Intuition
 * The problem requires finding two numbers in an array that sum up to a given
 * target. Using a hash table allows us to efficiently track the numbers we have
 * seen so far and quickly check for the required complement of the current
 * number.
 *
 * # Approach
 * The approach involves a single pass through the array:
 * 1. Iterate through the array, for each number, calculate its complement
 * (target - number).
 * 2. Check if this complement exists in the hash table.
 *    - If it does, we have found the two numbers whose indices are to be
 *    returned.
 *    - If it does not, add the current number and its index to the hash table.
 *
 * # Complexity
 * - Time complexity: O(n)
 *   - The algorithm iterates through the array once, taking O(n) time.
 *
 * - Space complexity: O(n)
 *   - The hash table stores each of the n elements in the array.
 */
val twoSumOnePassHashTable = TwoSum { nums: IntArray, target: Int ->
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return@TwoSum intArrayOf(map.getOrDefault(complement, 0), i)
        }
        map[nums[i]] = i
    }
    return@TwoSum intArrayOf()
}

/**
 * # Approach 4: Kotlin style One-pass Hash Table
 *
 * # Intuition
 * The problem requires finding two numbers in an array that sum up to a given
 * target. Using a hash table allows us to efficiently track the indices of the
 * numbers we need to find.
 *
 * # Approach
 * The approach involves a single pass through the array:
 * 1. Iterate through the array with both index and value using `forEachIndexed`
 * 2. For each number, check if it exists in the hash table.
 *    - If it does, it means we have already encountered the complement of the
 *    current number, and we can return the indices of these two numbers.
 *    - If it does not, add the difference between the target and the current
 *    number as the key, and the current index as the value in the hash table.
 *
 * # Complexity
 * - Time complexity: O(n)
 *   - The algorithm iterates through the array once, taking O(n) time.
 *
 * - Space complexity: O(n)
 *   - The hash table stores each of the n elements in the array.
 */
val twoSumOneHashMap = TwoSum { nums: IntArray, target: Int ->
    val map: MutableMap<Int, Int> = HashMap()
    nums.forEachIndexed { index, i ->
        map[i]?.let { return@TwoSum intArrayOf(it, index) }
        map[target - i] = index
    }
    return@TwoSum intArrayOf()
}

/**
 * 1. Two Sum
 * @link https://leetcode.com/problems/two-sum/
 */
fun interface TwoSum {
    /**
     * Performs the two-sum operation on the given array of integers.
     *
     * @param nums the array of integers.
     * @param target the target sum.
     * @return an array of indices representing the two numbers that add up to the target sum.
     */
    operator fun invoke(
        nums: IntArray,
        target: Int,
    ): IntArray
}
