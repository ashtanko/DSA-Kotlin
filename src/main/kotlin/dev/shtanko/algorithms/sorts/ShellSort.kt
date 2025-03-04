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
 * Shell sort is an in-place comparison sort that can be seen as either a generalization of insertion sort or a
 * variation of bubble sort. It starts by sorting pairs of elements far apart from each other and progressively
 * reducing the gap between elements to be compared. The final iteration uses a gap of 1, which is equivalent to
 * an insertion sort. The algorithm's time complexity depends on the chosen gap sequence.
 *
 * Worst-case performance:       O(n^2)
 * Best-case performance:        O(n log n)
 * Average performance:          Depends on the gap sequence
 * Worst-case space complexity:  O(1)
 * Stable: No
 */
data object ShellSort : Sortable {
    // Constant used to calculate the gap sequence
    const val GAP = 3

    /**
     * Performs the Shell sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        val size = arr.size
        var gap = 1
        while (gap < size / GAP) {
            gap = gap * GAP + 1
        }

        while (gap >= 1) {
            for (i in gap until size) {
                var j = i
                while (j >= gap && arr[j - gap] > arr[j]) {
                    arr.swap(j, j - gap)
                    j -= gap
                }
            }
            // Reduce the gap for the next iteration
            gap /= GAP
        }
    }
}
