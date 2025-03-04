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

abstract class AddBinaryTest<out T : AddBinary>(private val strategy: T) {
    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `add binary test`(
        a: String,
        b: String,
        expected: String,
    ) {
        measureTime("Add binary a: $a b: $b") {
            val actual = strategy(a, b)
            assertThat(actual).isEqualTo(expected)
        }
    }

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "",
                "",
                "",
            ),
            Arguments.of(
                "0",
                "",
                "0",
            ),
            Arguments.of(
                "",
                "0",
                "0",
            ),
            Arguments.of(
                "1",
                "",
                "1",
            ),
            Arguments.of(
                "",
                "1",
                "1",
            ),
            Arguments.of(
                "0",
                "1",
                "1",
            ),
            Arguments.of(
                "0",
                "0",
                "0",
            ),
            Arguments.of(
                "11",
                "1",
                "100",
            ),
            Arguments.of(
                "1010",
                "1011",
                "10101",
            ),
            Arguments.of(
                "10101010",
                "11001100",
                "101110110",
            ),
            Arguments.of(
                "10101010010010101001010010100100101",
                "101111111111111111",
                "10101010010010101111010010100100100",
            ),
        )
    }
}

class AddBinaryBitByBitComputationTest : AddBinaryTest<AddBinary>(addBinaryBitByBitComputation)
class AddBinaryBitManipulationTest : AddBinaryTest<AddBinary>(addBinaryBitManipulation)
