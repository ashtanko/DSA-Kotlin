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

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class BinomialTest {
    @DisplayName("Binomial Test")
    @ParameterizedTest(name = "n: {0}, k: {1} -> Expected: {2}")
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `binomial coefficient test`(
        n: Int,
        k: Int,
        expected: Long,
    ) {
        val actual = binomial(n, k)
        assertThat(actual).isEqualTo(expected)
    }

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(0, 1, 0),
            Arguments.of(1, 1, 1),
            Arguments.of(2, 1, 2),
            Arguments.of(3, 1, 3),
            Arguments.of(3, 2, 3),
            Arguments.of(4, 1, 4),
            Arguments.of(5, 0, 1),
            Arguments.of(5, 1, 5),
            Arguments.of(5, 2, 10),
            Arguments.of(5, 3, 10),
            Arguments.of(5, 4, 5),
            Arguments.of(5, 5, 1),
            Arguments.of(6, 0, 1),
            Arguments.of(6, 1, 6),
            Arguments.of(6, 2, 15),
            Arguments.of(6, 3, 20),
            Arguments.of(6, 4, 15),
            Arguments.of(6, 5, 6),
        )
    }
}
