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

import dev.shtanko.algorithms.extensions.findMinimumIndex
import dev.shtanko.algorithms.extensions.swap

/**
 * Selection sort is a simple comparison-based sorting algorithm. It works by dividing the array into a sorted
 * and an unsorted region. It repeatedly selects the smallest (or largest) element from the unsorted region
 * and moves it to the sorted region. The algorithm maintains two subarrays: the subarray of sorted elements
 * and the subarray of unsorted elements.
 *
 * Worst-case performance:       O(n^2)
 * Best-case performance:        O(n^2)
 * Average performance:          O(n^2)
 * Worst-case space complexity:  O(1)
 */
data object SelectionSort : Sortable {
    /**
     * Performs the selection sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        for (i in arr.indices) {
            val min = arr.findMinimumIndex(i)
            if (min != i) {
                arr.swap(min, i)
            }
        }
    }
}

/**
 * Stable Selection Sort is a variation of the selection sort algorithm that maintains the relative order
 * of elements with equal values. It achieves this by moving the minimum element to the current position
 * and shifting the elements to the right, instead of swapping them directly.
 *
 * Worst-case performance:       O(n^2)
 * Best-case performance:        O(n^2)
 * Average performance:          O(n^2)
 * Worst-case space complexity:  O(1)
 */
data object StableSelectionSort : Sortable {
    /**
     * Performs the stable selection sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        for (i in arr.indices) {
            var min = arr.findMinimumIndex(i)
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[min]) {
                    min = j
                }
            }
            // Move minimum element at current i.
            val key = arr[min]
            while (min > i) {
                arr[min] = arr[min - 1]
                min--
            }
            arr[i] = key
        }
    }
}
