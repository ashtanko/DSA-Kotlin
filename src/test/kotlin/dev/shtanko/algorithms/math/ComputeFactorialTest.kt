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

package dev.shtanko.algorithms.math

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class ComputeFactorialTest {
    @DisplayName("Compute Factorial")
    @ParameterizedTest(name = "n: {0} -> {1}")
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `factorial test`(n: Int, expected: Long) {
        val actual = computeFactorial(n)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `calculate factorial for negative number, should throw error`() {
        assertThrows<java.lang.IllegalStateException> {
            computeFactorial(-1)
        }
    }

    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                0,
                1,
            ),
            Arguments.of(
                1,
                1,
            ),
            Arguments.of(
                2,
                2,
            ),
            Arguments.of(
                3,
                6,
            ),
            Arguments.of(
                4,
                24,
            ),
            Arguments.of(
                5,
                120,
            ),
            Arguments.of(
                6,
                720,
            ),
            Arguments.of(
                7,
                5040,
            ),
            Arguments.of(
                8,
                40320,
            ),
            Arguments.of(
                9,
                362_880,
            ),
            Arguments.of(
                10,
                3_628_800,
            ),
            Arguments.of(
                11,
                39_916_800,
            ),
            Arguments.of(
                12,
                479_001_600,
            ),
        )
    }
}
