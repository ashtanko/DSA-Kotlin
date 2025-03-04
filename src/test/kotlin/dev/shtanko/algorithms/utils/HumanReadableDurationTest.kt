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

package dev.shtanko.algorithms.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class HumanReadableDurationTest {
    @DisplayName("Human Readable Duration")
    @ParameterizedTest(name = "Duration: {0} -> Expected: {1}")
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `to human readable duration test`(duration: Long, expected: String) {
        val actual = duration.toHumanReadableDuration()
        assertThat(actual).isEqualTo(expected)
    }

    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                0L,
                "Runtime: 0 ms",
            ),
            Arguments.of(
                1_000_000L,
                "Runtime: 1 ms",
            ),
            Arguments.of(
                2_000_000L,
                "Runtime: 2 ms",
            ),
            Arguments.of(
                12_000_000,
                "Runtime: 12 ms",
            ),
            Arguments.of(
                56_000_000,
                "Runtime: 56 ms",
            ),
            Arguments.of(
                65_700_000_000,
                "Runtime: 65,700 ms",
            ),
            Arguments.of(
                99_900_000_000,
                "Runtime: 99,900 ms",
            ),
        )
    }
}
