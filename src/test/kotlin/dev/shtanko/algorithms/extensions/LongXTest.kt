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

package dev.shtanko.algorithms.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class LongXTest {
    @ParameterizedTest
    @ArgumentsSource(ToReverseInputArgumentsProvider::class)
    fun `reverse long test`(n: Long, expected: Long) {
        val actual = n.reverse()
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ArgumentsSource(InputPalindromeArgumentsProvider::class)
    fun `is palindrome test`(n: Long, expected: Boolean) {
        val actual = n.isSuperPalindrome()
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `is super palindrome test`(n: Long, expected: Boolean) {
        val actual = n.isSuperPalindrome()
        assertThat(actual).isEqualTo(expected)
    }

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                4L,
                true,
            ),
            Arguments.of(
                12L,
                false,
            ),
            Arguments.of(
                24L,
                false,
            ),
            Arguments.of(
                484L,
                true,
            ),
            Arguments.of(
                676L,
                false,
            ),
            Arguments.of(
                1156L,
                false,
            ),
            Arguments.of(
                686,
                true,
            ),
        )
    }

    class ToReverseInputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1L,
                1L,
            ),
            Arguments.of(
                12L,
                21L,
            ),
            Arguments.of(
                121L,
                121L,
            ),
            Arguments.of(
                242L,
                242L,
            ),
            Arguments.of(
                484L,
                484L,
            ),
        )
    }

    class InputPalindromeArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                0L,
                true,
            ),
            Arguments.of(
                34L,
                false,
            ),
            Arguments.of(
                11L,
                true,
            ),
            Arguments.of(
                879L,
                false,
            ),
        )
    }
}
