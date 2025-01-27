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

package dev.shtanko.algorithms.leetcode.dp.linear

val climbingStairsBottomUpDp = ClimbingStairs { num ->
    if (num == 1) {
        return@ClimbingStairs 1
    }
    var oneBefore = 1
    var twoBefore = 1
    var total = 0
    repeat(num - 1) {
        total = oneBefore + twoBefore
        twoBefore = oneBefore
        oneBefore = total
    }
    return@ClimbingStairs total
}

/**
 * 70. Climbing Stairs
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">Source</a>
 */
fun interface ClimbingStairs {
    /**
     * Calculates the number of ways to climb the given number of stairs.
     *
     * @param num The number of stairs to climb.
     * @return The number of ways to climb the given number of stairs.
     */
    operator fun invoke(num: Int): Int
}
