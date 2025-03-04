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

import dev.shtanko.algorithms.extensions.generateRandomArray
import dev.shtanko.algorithms.utils.measureTime
import dev.shtanko.algorithms.utils.toHumanReadableByteCountBin
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.Locale
import java.util.stream.Stream
import kotlin.system.measureTimeMillis

class PerformanceTest {

    @DisplayName("On Slow Sorts")
    @ParameterizedTest(name = "Strategy: {0} Array: {1}")
    @ArgumentsSource(SlowSortsArgumentsProvider::class)
    fun `slow sorts test`(strategy: Sortable, arr: IntArray) {
        executionTimeReport(strategy, arr)
    }

    @DisplayName("On Fast Sorts")
    @ParameterizedTest(name = "Strategy: {0} Array: {1}")
    @ArgumentsSource(FastSortsArgumentsProvider::class)
    fun `fast sorts test`(strategy: Sortable, arr: IntArray) {
        executionTimeReport(strategy, arr)
    }

    @ParameterizedTest
    @ArgumentsSource(SlowScopeStrategiesInputArgumentsProvider::class)
    fun `slow strategies performance test`(n: Int, expected: Boolean) {
        val arr = n.generateRandomArray().toTypedArray()
        val fastStrategies = listOf(
            BubbleSort,
            SimpleBubbleSort,
            JvmSort,
            PancakeSort,
            GnomeSort,
            InsertionSort,
            InsertionSort2,
            SelectionSort,
            StableSelectionSort,
        )
        strategiesPerformanceTest(arr, fastStrategies, expected)
    }

    @DisplayName("Fast Strategies High Load On Random Array")
    @ParameterizedTest(name = "Array size: {0} Expected: {1}")
    @ArgumentsSource(FastScopeStrategiesInputArgumentsProvider::class)
    fun `fast strategies performance test`(n: Int, expected: Boolean) {
        val arr = n.generateRandomArray().toTypedArray()
        val fastStrategies = listOf(
            MergeSort,
            BottomUpMergeSort,
            QuickSort,
            ShellSort,
            HeapSort,
        )
        strategiesPerformanceTest(arr, fastStrategies, expected)
    }

    private fun strategiesPerformanceTest(
        arr: Array<Int>,
        strategies: List<Sortable>,
        expected: Boolean,
    ) {
        val totalTime = measureTimeMillis {
            strategies.map {
                it.invoke(arr)
            }
        }
        val availableProcessors = Runtime.getRuntime().availableProcessors()
        val totalMemory = Runtime.getRuntime().totalMemory()
        println(
            String.format(
                Locale.getDefault(),
                "Given arrays of length %d %s Consumed time: %d ms | CPU Cores: %d | Memory: %s",
                arr.size,
                "Fast strategies",
                totalTime,
                availableProcessors,
                totalMemory.toHumanReadableByteCountBin(),
            ),
        )
        assertThat(arr.isSorted()).isEqualTo(expected)
    }

    private fun executionTimeReport(strategy: Sortable, array: IntArray) {
        val arr = array.toTypedArray()
        measureTime(strategy, array) {
            strategy(arr)
        }
        assertTrue(arr.isSorted())
    }

    class SlowSortsArgumentsProvider : ArgumentsProvider {
        private val extraExtraSmallBatch = 100.generateRandomArray()
        private val extraSmallBatch = 500.generateRandomArray()
        private val smallBatch = 800.generateRandomArray()

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(BubbleSort, extraExtraSmallBatch),
            Arguments.of(BubbleSort, extraSmallBatch),
            Arguments.of(BubbleSort, smallBatch),
            Arguments.of(SimpleBubbleSort, extraExtraSmallBatch),
            Arguments.of(SimpleBubbleSort, extraSmallBatch),
            Arguments.of(SimpleBubbleSort, smallBatch),
            Arguments.of(JvmSort, extraExtraSmallBatch),
            Arguments.of(JvmSort, extraSmallBatch),
            Arguments.of(JvmSort, smallBatch),
            Arguments.of(PancakeSort, extraExtraSmallBatch),
            Arguments.of(PancakeSort, extraSmallBatch),
            Arguments.of(PancakeSort, smallBatch),
            Arguments.of(GnomeSort, extraExtraSmallBatch),
            Arguments.of(GnomeSort, extraSmallBatch),
            Arguments.of(GnomeSort, smallBatch),
            Arguments.of(InsertionSort, extraExtraSmallBatch),
            Arguments.of(InsertionSort, extraSmallBatch),
            Arguments.of(InsertionSort, smallBatch),
            Arguments.of(InsertionSort2, extraExtraSmallBatch),
            Arguments.of(InsertionSort2, extraSmallBatch),
            Arguments.of(InsertionSort2, smallBatch),
            Arguments.of(SelectionSort, extraExtraSmallBatch),
            Arguments.of(SelectionSort, extraSmallBatch),
            Arguments.of(SelectionSort, smallBatch),
            Arguments.of(StableSelectionSort, extraExtraSmallBatch),
            Arguments.of(StableSelectionSort, extraSmallBatch),
            Arguments.of(StableSelectionSort, smallBatch),
        )
    }

    class FastSortsArgumentsProvider : ArgumentsProvider {
        private val mergeSortStrategy = MergeSort
        private val bottomUpMergeSortStrategy = BottomUpMergeSort
        private val quickSortStrategy = QuickSort
        private val shellSortStrategy = ShellSort
        private val heapSortStrategy = HeapSort

        private val smallBatch = 30_000.generateRandomArray()
        private val mediumBatch = 50_000.generateRandomArray()
        private val largeBatch = 100_000.generateRandomArray()
        private val extraLargeBatch = 500_000.generateRandomArray()

        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(mergeSortStrategy, smallBatch),
            Arguments.of(mergeSortStrategy, mediumBatch),
            Arguments.of(mergeSortStrategy, largeBatch),
            Arguments.of(mergeSortStrategy, extraLargeBatch),
            Arguments.of(bottomUpMergeSortStrategy, smallBatch),
            Arguments.of(bottomUpMergeSortStrategy, mediumBatch),
            Arguments.of(bottomUpMergeSortStrategy, largeBatch),
            Arguments.of(bottomUpMergeSortStrategy, extraLargeBatch),
            Arguments.of(quickSortStrategy, smallBatch),
            Arguments.of(quickSortStrategy, mediumBatch),
            Arguments.of(quickSortStrategy, largeBatch),
            Arguments.of(quickSortStrategy, extraLargeBatch),
            Arguments.of(shellSortStrategy, smallBatch),
            Arguments.of(shellSortStrategy, mediumBatch),
            Arguments.of(shellSortStrategy, largeBatch),
            Arguments.of(shellSortStrategy, extraLargeBatch),
            Arguments.of(heapSortStrategy, smallBatch),
            Arguments.of(heapSortStrategy, mediumBatch),
            Arguments.of(heapSortStrategy, largeBatch),
            Arguments.of(heapSortStrategy, extraLargeBatch),
        )
    }

    private class FastScopeStrategiesInputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(10_000, true),
            Arguments.of(100_000, true),
            Arguments.of(500_000, true),
            Arguments.of(1000_000, true),
        )
    }

    private class SlowScopeStrategiesInputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(5000, true),
            Arguments.of(1000, true),
            Arguments.of(10_000, true),
            Arguments.of(20_000, true),
        )
    }
}
