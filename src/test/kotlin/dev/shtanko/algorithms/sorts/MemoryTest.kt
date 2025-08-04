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

import dev.shtanko.algorithms.utils.measureTime
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

class MemoryTest {
    @DisplayName("Sorts Memory Test")
    @ParameterizedTest(name = "Strategy: {0}")
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `sorts test`(testCase: Sortable) {
        execute(testCase, getSortedArray())
    }

    private fun execute(strategy: Sortable, array: IntArray) {
        measureTime(strategy, array) {
            strategy.invoke(array.toTypedArray())
        }
        assertTrue(array.isSorted())
    }

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            Arguments.of(BubbleSort),
            Arguments.of(SimpleBubbleSort),
            Arguments.of(InsertionSort),
            Arguments.of(InsertionSort2),
            Arguments.of(MergeSort),
            Arguments.of(BottomUpMergeSort),
            Arguments.of(QuickSort),
            Arguments.of(SelectionSort),
            Arguments.of(ShellSort),
            Arguments.of(HeapSort),
            Arguments.of(JvmSort),
            Arguments.of(PancakeSort),
            Arguments.of(GnomeSort),
        )
    }

    companion object {
        // 1000_000 // uncomment for original test
        private const val ARRAY_SIZE = 1000

        private fun getSortedArray(): IntArray {
            val array = IntArray(ARRAY_SIZE)
            for (i in 0 until ARRAY_SIZE) {
                array[i] = i
            }
            return array
        }
    }
}
