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
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * Each iteration, insertion sort removes one element from the input data, finds the location it belongs within
 * the sorted list, and inserts it there. It repeats until no input elements remain.
 *
 * Worst-case performance:       O(n^2)
 * Best-case performance:        O(n)
 * Average performance:          O(n^2)
 * Worst-case space complexity:  O(1)
 */
data object InsertionSort : Sortable {
    /**
     * Performs the insertion sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        for (i in 1 until arr.size) {
            for (j in i downTo 1) {
                if (arr[j - 1] < arr[j]) {
                    break
                }
                arr.swap(j, j - 1)
            }
        }
    }
}

/**
 * Implementation of the generic insertion sort algorithm.
 *
 * Worst-case performance:       O(n^2)
 * Best-case performance:        O(n)
 * Average performance:          O(n^2)
 * Worst-case space complexity:  O(1)
 */
data object InsertionSort2 : Sortable {
    /**
     * Performs the insertion sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        for (currentIndex in 1 until arr.size) {
            val currentValue = arr[currentIndex]
            var j = currentIndex
            while (j > 0 && arr[j - 1] > currentValue) {
                arr[j] = arr[j - 1]
                j--
            }
            arr[j] = currentValue
        }
    }
}
