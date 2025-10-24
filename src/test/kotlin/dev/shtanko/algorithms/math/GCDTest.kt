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

package dev.shtanko.algorithms.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

class GCDTest {
    @DisplayName("GCD Iterative Test")
    @ParameterizedTest(name = "a: {0}, b: {1} -> gcd: {2}")
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `gcd pair test`(
        a: Int,
        b: Int,
        expected: Int,
    ) {
        val actual = (a to b).gcd()
        assertEquals(expected, actual)
    }

    @DisplayName("GCD Recursive Test")
    @ParameterizedTest(name = "a: {0}, b: {1} -> gcd: {2}")
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `gcd recursive test`(
        a: Int,
        b: Int,
        expected: Int,
    ) {
        val actual = gcd(a, b)
        assertEquals(expected, actual)
    }

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations,
            context: ExtensionContext,
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(54, 24, 6),
            Arguments.of(42, 56, 14),
            Arguments.of(48, 18, 6),
            Arguments.of(48, 180, 12),
        )
    }
}
