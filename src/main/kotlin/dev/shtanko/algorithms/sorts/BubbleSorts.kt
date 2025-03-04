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
 * Bubble sort is a simple sorting algorithm that repeatedly steps through the list to be sorted, compares
 * each pair of adjacent items and swaps them if they are in the wrong order. The pass through the list is repeated
 * until no swaps are needed, which indicates that the list is sorted. The algorithm, which is a comparison sort,
 * is named for the way smaller or larger elements "bubble" to the top of the list. Although the algorithm is simple,
 * it is too slow and impractical for most problems even when compared to insertion sort. It can be practical
 * if the input is usually in sorted order but may occasionally have some out-of-order elements nearly in position.
 *
 * Worst-case performance:       O(n^2)
 * Best-case performance:        O(n)
 * Average performance:          O(n^2)
 * Worst-case space complexity:  O(1)
 */
data object BubbleSort : Sortable {
    /**
     * Performs the bubble sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        var exchanged: Boolean

        do {
            exchanged = false
            for (i in 1 until arr.size) {
                if (arr[i] < arr[i - 1]) {
                    arr.swap(i, i - 1)
                    exchanged = true
                }
            }
        } while (exchanged)
    }
}

/**
 * SimpleBubbleSort is a basic implementation of the bubble sort algorithm.
 * It iterates through the array multiple times, comparing adjacent elements and swapping them if they are out of order.
 * The algorithm continues this process until the array is sorted.
 *
 * Worst-case performance:       O(n^2)
 * Best-case performance:        O(n^2)
 * Average performance:          O(n^2)
 * Worst-case space complexity:  O(1)
 */
data object SimpleBubbleSort : Sortable {
    /**
     * Performs the simple bubble sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        for (i in 0 until arr.size - 1) {
            for (j in i + 1 until arr.size) {
                if (arr[i] > arr[j]) {
                    arr.swap(i, j)
                }
            }
        }
    }
}
