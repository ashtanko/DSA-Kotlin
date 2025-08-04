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
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

class FibonacciSequenceTest {
    @DisplayName("Fibonacci Sequence")
    @ParameterizedTest(name = "n: {0} -> {1}")
    @ArgumentsSource(InputSimpleArgumentsProvider::class)
    fun `simple test`(n: Int, expected: Int) {
        val actual = n.toFibonacciSequence()
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Fibonacci Iterative")
    @ParameterizedTest(name = "n: {0} -> {1}")
    @ArgumentsSource(InputIterativeArgumentsProvider::class)
    fun `iterative test`(n: Long, expected: Long) {
        val actual = Fibonacci.ITERATIVE.invoke(n)
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Fibonacci Recursive")
    @ParameterizedTest(name = "n: {0} -> {1}")
    @ArgumentsSource(InputRecursiveArgumentsProvider::class)
    fun `recursive test`(n: Long, expected: Long) {
        val actual = Fibonacci.RECURSIVE.invoke(n)
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("Fibonacci Tail Recursive")
    @ParameterizedTest(name = "n: {0} -> {1}")
    @ArgumentsSource(InputSimpleArgumentsProvider::class)
    fun `dp test`(n: Int, expected: Long) {
        val actual = fibonacciAt(n)
        assertThat(actual).isEqualTo(expected)
    }

    class InputSimpleArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(2, 1),
            Arguments.of(3, 2),
            Arguments.of(4, 3),
            Arguments.of(5, 5),
            Arguments.of(6, 8),
            Arguments.of(7, 13),
            Arguments.of(8, 21),
            Arguments.of(9, 34),
            Arguments.of(10, 55),
        )
    }

    class InputIterativeArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(2, 1),
            Arguments.of(11, 89),
            Arguments.of(12, 144),
            Arguments.of(13, 233),
            Arguments.of(14, 377),
            Arguments.of(15, 610),
        )
    }

    class InputRecursiveArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(2, 1),
            Arguments.of(16, 987),
            Arguments.of(17, 1597),
            Arguments.of(18, 2584),
            Arguments.of(19, 4181),
            Arguments.of(20, 6765),
        )
    }
}
