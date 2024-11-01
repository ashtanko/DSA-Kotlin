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
 * Implementation: Iterative
 * Space Complexity: O(n)
 * Ease of Use: Natural fit for linked lists
 * Stability: Stable
 * Performance: O(n log n)
 * Memory Usage: O(n), no recursion stack
 */
data object BottomUpMergeSort : Sortable {
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        val size = arr.size
        val tempArray = arr.copyOf()

        var width = 1
        while (width < size) {
            var i = 0
            while (i < size) {
                // Find the middle point
                val middle = kotlin.math.min(i + width, size)
                // Find the end of the current segment
                val end = kotlin.math.min(i + 2 * width, size)
                // Merge the sub-arrays array[i…middle-1] and array[middle…end-1] into tempArray
                merge(arr, tempArray, i, middle, end)
                i += 2 * width
            }
            // Copy the merged array back to the original array
            tempArray.copyInto(arr)
            width *= 2
        }
    }

    private fun <T : Comparable<T>> merge(
        array: Array<T>,
        tempArray: Array<T>,
        start: Int,
        middle: Int,
        end: Int,
    ) {
        var i = start
        var j = middle
        var k = start

        // Merge the two sub-arrays into tempArray
        while (i < middle && j < end) {
            if (array[i] <= array[j]) {
                tempArray[k] = array[i]
                i++
            } else {
                tempArray[k] = array[j]
                j++
            }
            k++
        }

        // Copy remaining elements of the left half, if any
        while (i < middle) {
            tempArray[k] = array[i]
            i++
            k++
        }

        // Copy remaining elements of the right half, if any
        while (j < end) {
            tempArray[k] = array[j]
            j++
            k++
        }
    }
}
