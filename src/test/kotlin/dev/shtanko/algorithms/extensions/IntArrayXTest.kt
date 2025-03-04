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

class IntArrayXTest {
    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `reverse int array test`(
        arr: IntArray,
        start: Int,
        end: Int,
        expected: IntArray,
    ) {
        arr.reverse(start, end)
        assertThat(arr).isEqualTo(expected)
    }

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(), 0, 0, intArrayOf()),
            Arguments.of(intArrayOf(1), 0, 0, intArrayOf(1)),
            Arguments.of(intArrayOf(1, 3), 0, 2, intArrayOf(3, 1)),
            Arguments.of(intArrayOf(4, 8, 15, 16, 23, 42), 0, 6, intArrayOf(42, 23, 16, 15, 8, 4)),
            Arguments.of(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 5, 9, intArrayOf(1, 2, 3, 4, 5, 9, 8, 7, 6)),
        )
    }
}
