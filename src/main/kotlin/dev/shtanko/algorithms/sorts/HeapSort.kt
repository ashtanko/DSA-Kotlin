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

import dev.shtanko.algorithms.extensions.swap

/**
 * Heap sort is a comparison-based sorting algorithm that uses a binary heap data structure.
 * It divides the input into a sorted and an unsorted region, and it iteratively shrinks the unsorted region
 * by extracting the largest element from it and inserting it into the sorted region. The algorithm
 * efficiently builds a max heap on the input array to facilitate the extraction of maximum elements.
 *
 * Worst-case performance:       O(n log n)
 * Best-case performance:        O(n log n)
 * Average performance:          O(n log n)
 * Worst-case space complexity:  O(1)
 */
data object HeapSort : Sortable {
    /**
     * Performs the heap sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        val size = arr.size
        for (i in size / 2 - 1 downTo 0) {
            heapify(arr, size, i)
        }

        for (i in size - 1 downTo 0) {
            arr.swap(0, i)
            heapify(arr, i, 0)
        }
    }

    /**
     * Performs heapify operation on the array.
     *
     * @param array The array to heapify.
     * @param size The size of the heap.
     * @param index The index of the current element in the heap.
     * @param T The type of elements in the array, must be comparable.
     */
    @Suppress("SAY_NO_TO_VAR")
    private fun <T : Comparable<T>> heapify(
        array: Array<T>,
        size: Int,
        index: Int,
    ) {
        var largest = index
        val left = 2 * index + 1
        val right = 2 * index + 2

        if (left < size && array[left] > array[largest]) {
            largest = left
        }

        if (right < size && array[right] > array[largest]) {
            largest = right
        }

        if (largest != index) {
            array.swap(index, largest)
            heapify(array, size, largest)
        }
    }
}
