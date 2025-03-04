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
 * Recursive Quick Sort is a sorting algorithm that works by selecting a pivot element from the array and
 * partitioning the other elements into two sub-arrays, according to whether they are less than or greater
 * than the pivot.
 * It then recursively sorts the sub-arrays. This implementation uses a functional approach with Kotlin's
 * extension functions.
 *
 * Worst-case performance:       O(n^2)
 * Best-case performance:        O(n log n)
 * Average performance:          O(n log n)
 * Worst-case space complexity:  O(log n)
 */
data object QuickSortRecursive : Sortable {
    /**
     * Performs the recursive quick sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        val sorted = arr.toList().quickSort()
        for (i in sorted.indices) {
            arr[i] = sorted[i]
        }
    }
}

/**
 * Extension function to perform quick sort on a list of comparable elements.
 *
 * @receiver List<T> The list to be sorted.
 * @return List<T> A new list containing the sorted elements.
 */
fun <T : Comparable<T>> List<T>.quickSort(): List<T> =
    when {
        size < 2 -> this
        else -> {
            val pivot = first()
            val (smaller, greater) = drop(1).partition { it <= pivot }
            smaller.quickSort() + pivot + greater.quickSort()
        }
    }
