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

/**
 * Merge sort is an efficient, stable, and comparison-based sorting algorithm.
 * It works by dividing the unsorted list into n sublists, each containing one element,
 * and then repeatedly merging sublists to produce new sorted sublists until there is only one sublist remaining.
 *
 * Invented in 1945 by John von Neumann, merge sort is an efficient algorithm using the divide and conquer approach
 * which is to divide a big problem into smaller problems and solve them. Conceptually, a merge sort works as follows:
 * 1) Divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
 * 2) Repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining.
 *
 * Worst-case performance:       O(n log n)
 * Best-case performance:        O(n log n)
 * Average performance:          O(n log n)
 * Worst-case space complexity:  O(n)
 */
data object MergeSort : Sortable {
    /**
     * Performs the merge sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        val aux = arr.clone()
        sort(arr, aux, 0, arr.size - 1)
    }

    /**
     * Recursively sorts the array using merge sort.
     *
     * @param arr The array to sort.
     * @param aux The auxiliary array used for merging.
     * @param low The low index of the current range.
     * @param high The high index of the current range.
     * @param T The type of elements in the array, must be comparable.
     */
    private fun <T : Comparable<T>> sort(
        arr: Array<T>,
        aux: Array<T>,
        low: Int,
        high: Int,
    ) {
        if (high <= low) {
            return
        }
        val mid = (low + high) / 2
        sort(arr, aux, low, mid)
        sort(arr, aux, mid + 1, high)
        merge(arr, aux, low, mid, high)
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     *
     * @param arr The array to sort.
     * @param aux The auxiliary array used for merging.
     * @param low The low index of the current range.
     * @param mid The mid index of the current range.
     * @param high The high index of the current range.
     * @param T The type of elements in the array, must be comparable.
     */
    private fun <T : Comparable<T>> merge(
        arr: Array<T>,
        aux: Array<T>,
        low: Int,
        mid: Int,
        high: Int,
    ) {
        System.arraycopy(arr, low, aux, low, high - low + 1)

        var i = low
        var j = mid + 1

        for (k in low..high) {
            when {
                i > mid -> arr[k] = aux[j++]
                j > high -> arr[k] = aux[i++]
                aux[j] < aux[i] -> arr[k] = aux[j++]
                else -> arr[k] = aux[i++]
            }
        }
    }
}
