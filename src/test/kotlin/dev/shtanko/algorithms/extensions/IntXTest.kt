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
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class IntXTest {
    @ParameterizedTest
    @ArgumentsSource(InputPrimeArgumentsProvider::class)
    fun `is prime test`(num: Int, expected: Boolean) {
        val actual = num.isPrime()
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ArgumentsSource(InputIsEvenArgumentsProvider::class)
    fun `is even test`(n: Int, expected: Boolean) {
        val actual = n.isEven()
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ArgumentsSource(InputIsEvenArgumentsProvider::class)
    fun `is even fun interface test`(n: Int, expected: Boolean) {
        val actual = isEven.invoke(n)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `random array test`() {
        assertEquals(3, 3.generateRandomArray().size)
    }

    @Test
    fun `less than zero test`() {
        assertTrue((-1).isLessThanZero())
    }

    @Test
    fun `more than zero test`() {
        assertFalse(1.isLessThanZero())
    }

    class InputIsEvenArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(2, true),
            Arguments.of(3, false),
            Arguments.of(4, true),
            Arguments.of(6, true),
            Arguments.of(8, true),
            Arguments.of(9, false),
            Arguments.of(11, false),
            Arguments.of(100, true),
            Arguments.of(Int.MAX_VALUE, false),
        )
    }

    class InputPrimeArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                0,
                false,
            ),
            Arguments.of(
                2,
                true,
            ),
            Arguments.of(
                3,
                true,
            ),
            Arguments.of(
                4,
                false,
            ),
            Arguments.of(
                5,
                true,
            ),
            Arguments.of(
                7,
                true,
            ),
            Arguments.of(
                11,
                true,
            ),
            Arguments.of(
                13,
                true,
            ),
            Arguments.of(
                17,
                true,
            ),
            Arguments.of(
                19,
                true,
            ),
            Arguments.of(
                23,
                true,
            ),
            Arguments.of(
                29,
                true,
            ),
            Arguments.of(
                31,
                true,
            ),
            Arguments.of(
                37,
                true,
            ),
        )
    }
}
