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

class CharXTest {
    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `random string test`(
        range: CharRange,
        len: Int,
        expected: Int,
    ) {
        val randomString = range.randomString(len)
        val actual = randomString.length
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ArgumentsSource(InputVowelArgumentsProvider::class)
    fun `is vowel test`(c: Char, expected: Boolean) {
        val actual = c.isVowel()
        assertThat(actual).isEqualTo(expected)
    }

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of('a'..'z', 0, 0),
            Arguments.of('a'..'z', 6, 6),
            Arguments.of('A'..'Z', 6, 6),
            Arguments.of('A'..'Z', 600, 600),
        )
    }

    class InputVowelArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of('a', true),
            Arguments.of('e', true),
            Arguments.of('i', true),
            Arguments.of('o', true),
            Arguments.of('u', true),
            Arguments.of('r', false),
            Arguments.of('q', false),
            Arguments.of('z', false),
            Arguments.of('x', false),
        )
    }
}
