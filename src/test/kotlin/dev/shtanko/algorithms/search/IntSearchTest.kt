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

package dev.shtanko.algorithms.search

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

@Suppress("ArrayPrimitive")
abstract class IntSearchTest<out T : Searchable<Int>>(private val strategy: T) {
    @DisplayName("Int Array Search Test")
    @ParameterizedTest(name = "Array: {0}, Element: {1} -> Expected: {2}")
    @ArgumentsSource(InputIntArrayArgumentsProvider::class)
    fun `int array test`(
        arr: Array<Int>,
        element: Int,
        expected: Int,
    ) {
        val actual = strategy(arr, element)
        assertEquals(expected, actual)
    }

    private class InputIntArrayArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(arrayOf<Int>(), 1, -1),
            Arguments.of(arrayOf(1), 1, 0),
            Arguments.of(arrayOf(1), 2, -1),
            Arguments.of(arrayOf(4, 8), 4, 0),
            Arguments.of(arrayOf(4, 8), 8, 1),
            Arguments.of(arrayOf(4, 8), 9, -1),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 4, 0),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 8, 1),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 15, 2),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 16, 3),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 23, 4),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 42, 5),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 43, -1),
        )
    }
}
