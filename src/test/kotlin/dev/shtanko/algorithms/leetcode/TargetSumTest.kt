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

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class TargetSumTest<out T : TargetSum>(private val strategy: T) {
    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `find target sum ways test`(
        nums: IntArray,
        target: Int,
        expected: Int,
    ) {
        val actual = strategy(nums, target)
        assertThat(actual).isEqualTo(expected)
    }

    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 1, 1, 1, 1),
                3,
                5,
            ),
            Arguments.of(
                intArrayOf(1),
                1,
                1,
            ),
            Arguments.of(
                intArrayOf(0),
                1,
                0,
            ),
            Arguments.of(
                intArrayOf(0),
                0,
                2,
            ),
            Arguments.of(
                intArrayOf(0, 0),
                0,
                4,
            ),
            Arguments.of(
                intArrayOf(1, 1, 1),
                -1,
                3,
            ),
            Arguments.of(
                intArrayOf(1, 2),
                1,
                1,
            ),
            Arguments.of(
                intArrayOf(1, 2),
                2,
                0,
            ),
            Arguments.of(
                intArrayOf(1, 2, 3),
                4,
                1,
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                4,
                0,
            ),
            Arguments.of(
                intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                2,
                792,
            ),
        )
    }
}

class TargetSumBruteForceTest : TargetSumTest<TargetSum>(TargetSumBruteForce())
class TargetSumMemoizationTest : TargetSumTest<TargetSum>(targetSumMemoization)
class TwoDTest : TargetSumTest<TargetSum>(twoPassSolution)
class OneDTest : TargetSumTest<TargetSum>(onePassSolution)
