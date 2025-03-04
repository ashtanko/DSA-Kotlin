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

abstract class MinDistanceTest<out T : MinDistance>(private val strategy: T) {
    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `min distance test`(
        word1: String,
        word2: String,
        expected: Int,
    ) {
        val actual = strategy(word1, word2)
        assertThat(actual).isEqualTo(expected)
    }

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "",
                "",
                0,
            ),
            Arguments.of(
                "q",
                "q",
                0,
            ),
            Arguments.of(
                "sea",
                "eat",
                2,
            ),
            Arguments.of(
                "leetcode",
                "etco",
                4,
            ),
        )
    }
}

class MinDistanceLcsTest : MinDistanceTest<MinDistance>(minDistanceLcs)
class MinDistanceLcsMemoTest : MinDistanceTest<MinDistance>(minDistanceLcsMemo)
class MinDistanceLcsDpTest : MinDistanceTest<MinDistance>(minDistanceLcsDp)
class MinDistanceDpTest : MinDistanceTest<MinDistance>(minDistanceDp)
class MinDistance1DdpTest : MinDistanceTest<MinDistance>(minDistance1Ddp)
