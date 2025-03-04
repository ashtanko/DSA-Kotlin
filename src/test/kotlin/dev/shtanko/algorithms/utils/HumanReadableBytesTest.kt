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

class HumanReadableBytesTest {
    @DisplayName("Positive Byte Count Binary")
    @ParameterizedTest(name = "Bytes: {0} -> Expected: {1}")
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `human readable positive byte count binary test`(bytes: Long, expected: String) {
        val actual = bytes.toHumanReadableByteCountBin()
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Negative Byte Count Binary")
    @ParameterizedTest(name = "Bytes: {0} -> Expected: {1}")
    @ArgumentsSource(InputNegativeArgumentsProvider::class)
    fun `human readable negative byte count binary test`(bytes: Long, expected: String) {
        val actual = bytes.toHumanReadableByteCountBin()
        assertThat(actual).isEqualTo(expected)
    }

    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                0,
                "0 B",
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
                "1000 B",
            ),
            Arguments.of(
                1023,
                "1023 B",
            ),
            Arguments.of(
                1024,
                "1.0 KiB",
            ),
            Arguments.of(
                1728,
                "1.7 KiB",
            ),
            Arguments.of(
                110_592,
                "108.0 KiB",
            ),
            Arguments.of(
                7_077_888,
                "6.8 MiB",
            ),
            Arguments.of(
                452_984_832,
                "432.0 MiB",
            ),
            Arguments.of(
                28_991_029_248,
                "27.0 GiB",
            ),
            Arguments.of(
                1_855_425_871_872,
                "1.7 TiB",
            ),
            Arguments.of(
                9_223_372_036_854_775_807,
                "8.0 EiB",
            ),
            Arguments.of(
                Long.MAX_VALUE,
                "8.0 EiB",
            ),
        )
    }

    private class InputNegativeArgumentsProvider : ArgumentsProvider {
        @Suppress("LongMethod")
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
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
                "-1000 B",
            ),
            Arguments.of(
                -1023,
                "-1023 B",
            ),
            Arguments.of(
                -1024,
                "-1.0 KiB",
            ),
            Arguments.of(
                -1728,
                "-1.7 KiB",
            ),
            Arguments.of(
                -110_592,
                "-108.0 KiB",
            ),
            Arguments.of(
                -7_077_888,
                "-6.8 MiB",
            ),
            Arguments.of(
                -452_984_832,
                "-432.0 MiB",
            ),
            Arguments.of(
                -28_991_029_248,
                "-27.0 GiB",
            ),
            Arguments.of(
                -1_855_425_871_872,
                "-1.7 TiB",
            ),
            Arguments.of(
                -9_223_372_036_854_775_807,
                "-8.0 EiB",
            ),
            Arguments.of(
                -Long.MAX_VALUE,
                "-8.0 EiB",
            ),
            Arguments.of(
                Long.MIN_VALUE,
                "-8.0 EiB",
            ),
        )
    }
}
