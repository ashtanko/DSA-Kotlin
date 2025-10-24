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

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

class HumanReadableByteCountSiTest {
    @DisplayName("Positive Byte Count Binary SI")
    @ParameterizedTest(name = "Bytes: {0} -> Expected: {1}")
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `human readable positive byte count binary SI test`(bytes: Long, expected: String) {
        val actual = bytes.toHumanReadableByteCountSi()
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Negative Byte Count Binary SI")
    @ParameterizedTest(name = "Bytes: {0} -> Expected: {1}")
    @ArgumentsSource(InputNegativeArgumentsProvider::class)
    fun `human readable negative byte count binary SI test`(bytes: Long, expected: String) {
        val actual = bytes.toHumanReadableByteCountSi()
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    private class InputArgumentsProvider : ArgumentsProvider {
        @Suppress("LongMethod")
        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext,
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                0,
                "0 B",
            ),
            Arguments.of(
                1,
                "1 B",
            ),
            Arguments.of(
                27,
                "27 B",
            ),
            Arguments.of(
                999,
                "999 B",
            ),
            Arguments.of(
                1000,
                "1.0 kB",
            ),
            Arguments.of(
                1023,
                "1.0 kB",
            ),
            Arguments.of(
                1024,
                "1.0 kB",
            ),
            Arguments.of(
                1728,
                "1.7 kB",
            ),
            Arguments.of(
                110_592,
                "110.6 kB",
            ),
            Arguments.of(
                7_077_888,
                "7.1 MB",
            ),
            Arguments.of(
                452_984_832,
                "453.0 MB",
            ),
            Arguments.of(
                28_991_029_248,
                "29.0 GB",
            ),
            Arguments.of(
                1_855_425_871_872,
                "1.9 TB",
            ),
            Arguments.of(
                9_223_372_036_854_775_807,
                "9.2 EB",
            ),
            Arguments.of(
                Long.MAX_VALUE,
                "9.2 EB",
            ),
        )
    }

    private class InputNegativeArgumentsProvider : ArgumentsProvider {
        @Suppress("LongMethod")
        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext,
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                -0,
                "0 B",
            ),
            Arguments.of(
                -1,
                "-1 B",
            ),
            Arguments.of(
                -27,
                "-27 B",
            ),
            Arguments.of(
                -999,
                "-999 B",
            ),
            Arguments.of(
                -1000,
                "-1.0 kB",
            ),
            Arguments.of(
                -1023,
                "-1.0 kB",
            ),
            Arguments.of(
                -1024,
                "-1.0 kB",
            ),
            Arguments.of(
                -1728,
                "-1.7 kB",
            ),
            Arguments.of(
                -110_592,
                "-110.6 kB",
            ),
            Arguments.of(
                -7_077_888,
                "-7.1 MB",
            ),
            Arguments.of(
                -452_984_832,
                "-453.0 MB",
            ),
            Arguments.of(
                -28_991_029_248,
                "-29.0 GB",
            ),
            Arguments.of(
                -1_855_425_871_872,
                "-1.9 TB",
            ),
            Arguments.of(
                -9_223_372_036_854_775_807,
                "-9.2 EB",
            ),
            Arguments.of(
                -Long.MAX_VALUE,
                "-9.2 EB",
            ),
            Arguments.of(
                -Long.MIN_VALUE,
                "-9.2 EB",
            ),
            Arguments.of(
                Long.MIN_VALUE,
                "-9.2 EB",
            ),
        )
    }
}
