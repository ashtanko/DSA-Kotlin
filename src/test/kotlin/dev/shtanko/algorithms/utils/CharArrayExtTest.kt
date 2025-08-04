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

import dev.shtanko.algorithms.extensions.reverse
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

class CharArrayExtTest {
    @DisplayName("Reverse Char Array")
    @ParameterizedTest(name = "Array: {0}, Left: {1}, Right: {2} -> Expected: {3}")
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `reverse char array test`(
        arr: CharArray,
        left: Int,
        right: Int,
        expected: CharArray,
    ) {
        arr.reverse(left, right)
        assertArrayEquals(expected, arr)
    }

    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                charArrayOf(),
                0,
                0,
                charArrayOf(),
            ),
            Arguments.of(
                charArrayOf('a', 'b', 'c', 'd'),
                0,
                0,
                charArrayOf('a', 'b', 'c', 'd'),
            ),
            Arguments.of(
                charArrayOf('a', 'b'),
                0,
                1,
                charArrayOf('b', 'a'),
            ),
            Arguments.of(
                charArrayOf('a', 'b'),
                1,
                0,
                charArrayOf('a', 'b'),
            ),
        )
    }
}
