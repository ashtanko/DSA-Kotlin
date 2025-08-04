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

package dev.shtanko.algorithms.bitwise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

class BinaryRepresentationTest {
    @ParameterizedTest
    @ArgumentsSource(LongArgs::class)
    fun `long to bin string test`(n: Long, expected: String) {
        val actual = n.bin()
        assertThat(actual).isEqualTo(expected)
    }

    private class LongArgs : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                7L,
                "00000000000000000000000000000111",
            ),
            Arguments.of(
                4L,
                "00000000000000000000000000000100",
            ),
            Arguments.of(
                0L,
                "00000000000000000000000000000000",
            ),
            Arguments.of(
                1L,
                "00000000000000000000000000000001",
            ),
            Arguments.of(
                2L,
                "00000000000000000000000000000010",
            ),
            Arguments.of(
                234L,
                "00000000000000000000000011101010",
            ),
            Arguments.of(
                2_342_354_676L,
                "00001011100111010111111011110100",
            ),
            Arguments.of(
                Long.MAX_VALUE,
                "01111111111111111111111111111111",
            ),
            Arguments.of(
                Long.MIN_VALUE,
                "00000000000000000000000000000000",
            ),
        )
    }
}
