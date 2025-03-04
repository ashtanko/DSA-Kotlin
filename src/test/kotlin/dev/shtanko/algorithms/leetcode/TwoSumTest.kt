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

import dev.shtanko.algorithms.utils.measureTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class TwoSumTest<out T : TwoSum>(private val strategy: T) {
    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `two sum test`(
        array: IntArray,
        target: Int,
        expected: IntArray,
    ) {
        measureTime("Two sum array ${array.toList()}") {
            val actual = strategy(array, target)
            assertThat(actual).isEqualTo(expected)
        }
    }

    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(),
                0,
                intArrayOf(),
            ),
            Arguments.of(
                intArrayOf(4, 8, 15, 16, 23),
                9,
                intArrayOf(),
            ),
            Arguments.of(
                intArrayOf(4, 8, 15, 16, 23),
                12,
                intArrayOf(0, 1),
            ),
            Arguments.of(
                intArrayOf(4, 8, 15, 16, 23),
                39,
                intArrayOf(3, 4),
            ),
            Arguments.of(
                intArrayOf(2, 7, 11, 15),
                9,
                intArrayOf(0, 1),
            ),
            Arguments.of(
                intArrayOf(3, 2, 4),
                6,
                intArrayOf(1, 2),
            ),
            Arguments.of(
                intArrayOf(3, 3),
                6,
                intArrayOf(0, 1),
            ),
        )
    }
}

class TwoSumBruteForceTest : TwoSumTest<TwoSum>(twoSumBruteForce)
class TwoSumTwoPassHashTableTest : TwoSumTest<TwoSum>(twoSumTwoPassHashTable)
class TwoSumOnePassHashTableTest : TwoSumTest<TwoSum>(twoSumOnePassHashTable)
class TwoSumOneHashMapTest : TwoSumTest<TwoSum>(twoSumOneHashMap)
