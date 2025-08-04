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

package dev.shtanko.algorithms.sorts

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream
import kotlin.random.Random

@Suppress("ArrayPrimitive")
abstract class SortTest<out T : Sortable>(private val strategy: T) {

    @DisplayName("Test sort on integer array")
    @ParameterizedTest(name = "input: {0}, expected: {1}")
    @ArgumentsSource(InputArrayArgumentsProvider::class)
    fun `integer array test`(arr: Array<Int>, expected: Array<Int>) {
        strategy.invoke(arr)
        assertArrayEquals(expected, arr)
    }

    @DisplayName("Test sort on float array")
    @ParameterizedTest(name = "input: {0}, expected: {1}")
    @ArgumentsSource(InputFloatArgumentsProvider::class)
    fun `float array test`(arr: Array<Float>, expected: Array<Float>) {
        strategy.invoke(arr)
        assertArrayEquals(expected, arr)
    }

    @DisplayName("Test sort on random array")
    @ParameterizedTest(name = "input: {0}, is sorted: {1}")
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `is sorted test`(arr: Array<Int>, expected: Boolean) {
        strategy.invoke(arr)
        val actual = arr.isSorted()
        assertEquals(expected, actual)
    }

    @DisplayName("Test sort on string array")
    @ParameterizedTest(name = "input: {0}, expected: {1}")
    @ArgumentsSource(InputStringArrayArgumentsProvider::class)
    fun `string array test`(arr: Array<String>, expected: Array<String>) {
        strategy.invoke(arr)
        assertArrayEquals(expected, arr)
    }

    @DisplayName("Test sort on an object array")
    @ParameterizedTest(name = "input: {0}, expected: {1}")
    @ArgumentsSource(InputObjectArrayArgumentsProvider::class)
    fun `object test`(arr: Array<TestObject>, expected: Array<TestObject>) {
        strategy.invoke(arr)
        assertArrayEquals(expected, arr)
    }

    private class InputArrayArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(arrayOf<Int>(), emptyArray<Int>()),
            Arguments.of(arrayOf(0), arrayOf(0)),
            Arguments.of(arrayOf(4), arrayOf(4)),
            Arguments.of(arrayOf(-4), arrayOf(-4)),
            Arguments.of(arrayOf(4, 8), arrayOf(4, 8)),
            Arguments.of(arrayOf(-4, -8), arrayOf(-8, -4)),
            Arguments.of(arrayOf(4, 4), arrayOf(4, 4)),
            Arguments.of(arrayOf(42, 23), arrayOf(23, 42)),
            Arguments.of(arrayOf(1, 2, -3), arrayOf(-3, 1, 2)),
            Arguments.of(arrayOf(1, 2, 3, 4, 5), arrayOf(1, 2, 3, 4, 5)),
            Arguments.of(arrayOf(5, 4, 3, 2, 1), arrayOf(1, 2, 3, 4, 5)),
            Arguments.of(arrayOf(4, 2, 5, 1, 3, 4, 1), arrayOf(1, 1, 2, 3, 4, 4, 5)),
            Arguments.of(arrayOf(1, 2, 3, 4, 5, 6, 7), arrayOf(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(arrayOf(7, 6, 5, 4, 3, 2, 1), arrayOf(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(arrayOf(42, 23, 16, 15, 8, 4), arrayOf(4, 8, 15, 16, 23, 42)),
            Arguments.of(arrayOf(15, 8, 16, 4, 42, 23), arrayOf(4, 8, 15, 16, 23, 42)),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), arrayOf(4, 8, 15, 16, 23, 42)),
            Arguments.of(arrayOf(-4, -8, -15, -16, -23, -42), arrayOf(-42, -23, -16, -15, -8, -4)),
            Arguments.of(arrayOf(-42, -23, -16, -15, -8, -4), arrayOf(-42, -23, -16, -15, -8, -4)),
            Arguments.of(arrayOf(4, 8, 15, 16, 42, 23), arrayOf(4, 8, 15, 16, 23, 42)),
            Arguments.of(arrayOf(45, 23, 53, 43, 18, 24, 8, 95, 101), arrayOf(8, 18, 23, 24, 43, 45, 53, 95, 101)),
            Arguments.of(arrayOf(41, 15, 82, 5, 65, 19, 32, 43, 8), arrayOf(5, 8, 15, 19, 32, 41, 43, 65, 82)),
            Arguments.of(arrayOf(22, 7, 2, -5, 8, 4), arrayOf(-5, 2, 4, 7, 8, 22)),
            Arguments.of(
                arrayOf(61, 109, 149, 111, 34, 2, 24, 119, 122, 125, 27, 145),
                arrayOf(2, 24, 27, 34, 61, 109, 111, 119, 122, 125, 145, 149),
            ),
        )
    }

    private class InputFloatArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(arrayOf<Float>(), emptyArray<Float>()),
            Arguments.of(arrayOf(1f), arrayOf(1f)),
            Arguments.of(arrayOf(5.2f, 1.3f, 0.7f, 3.8f, 2.6f), arrayOf(0.7f, 1.3f, 2.6f, 3.8f, 5.2f)),
            Arguments.of(arrayOf(5.2f, -1.3f, -0.7f, 3.8f, 2.6f), arrayOf(-1.3f, -0.7f, 2.6f, 3.8f, 5.2f)),
        )
    }

    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(getRandomArray(), true),
            Arguments.of(arrayOf(1, 2, 2, 1), true),
        )

        private fun getRandomArray(): Array<Int> {
            val arr = Array(10_000) { 0 }
            for (i in 0 until 10_000) {
                arr[i] = Random.nextInt(10_000)
            }
            return arr
        }
    }

    private class InputStringArrayArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(arrayOf<String>(), emptyArray<String>()),
            Arguments.of(arrayOf("A"), arrayOf("A")),
            Arguments.of(arrayOf("a"), arrayOf("a")),
            Arguments.of(arrayOf("aa"), arrayOf("aa")),
            Arguments.of(arrayOf("a", "a"), arrayOf("a", "a")),
            Arguments.of(arrayOf("A", "B", "C"), arrayOf("A", "B", "C")),
            Arguments.of(arrayOf("D", "C", "B", "A"), arrayOf("A", "B", "C", "D")),
            Arguments.of(
                arrayOf("A", "c", "B", "e", "d", "F", "y", "G"),
                arrayOf("A", "B", "F", "G", "c", "d", "e", "y"),
            ),
            Arguments.of(arrayOf("1", "1"), arrayOf("1", "1")),
            Arguments.of(arrayOf("2", "1"), arrayOf("1", "2")),
            Arguments.of(
                arrayOf("", "Hello", "foo", "bar", "foo", "f00", "%*&^*&^&", "***"),
                arrayOf("", "%*&^*&^&", "***", "Hello", "bar", "f00", "foo", "foo"),
            ),
        )
    }

    private class InputObjectArrayArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    TestObject.empty(
                        strategy = FullToStringStrategy,
                    ),
                ),
                arrayOf(
                    TestObject.empty(
                        strategy = FullToStringStrategy,
                    ),
                ),
            ),
            Arguments.of(
                arrayOf(TestObject(0, "Jake"), TestObject(3, "William")),
                arrayOf(TestObject(0, "Jake"), TestObject(3, "William")),
            ),
            Arguments.of(
                arrayOf(TestObject(0, "William"), TestObject(3, "Anna")),
                arrayOf(TestObject(3, "Anna"), TestObject(0, "William")),
            ),
            Arguments.of(
                arrayOf(TestObject(0, "Jake"), TestObject(1, "Anna"), TestObject(2, "Alex")),
                arrayOf(TestObject(2, "Alex"), TestObject(1, "Anna"), TestObject(0, "Jake")),
            ),
            Arguments.of(
                arrayOf(TestObject(0, "A"), TestObject(0, "A"), TestObject(0, "A")),
                arrayOf(TestObject(0, "A"), TestObject(0, "A"), TestObject(0, "A")),
            ),
            Arguments.of(
                arrayOf(TestObject(0, "C"), TestObject(0, "B"), TestObject(0, "A")),
                arrayOf(TestObject(0, "A"), TestObject(0, "B"), TestObject(0, "C")),
            ),
            Arguments.of(
                arrayOf(TestObject(2, "A"), TestObject(1, "B"), TestObject(0, "C")),
                arrayOf(TestObject(2, "A"), TestObject(1, "B"), TestObject(0, "C")),
            ),
            Arguments.of(
                arrayOf(
                    TestObject(2, "", strategy = FullToStringStrategy),
                    TestObject(1, "", strategy = FullToStringStrategy),
                    TestObject(0, "", strategy = FullToStringStrategy),
                ),
                arrayOf(
                    TestObject(0, "", strategy = FullToStringStrategy),
                    TestObject(1, "", strategy = FullToStringStrategy),
                    TestObject(2, "", strategy = FullToStringStrategy),
                ),
            ),
        )
    }
}
