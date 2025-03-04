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

import dev.shtanko.algorithms.extensions.flip

/**
 * Pancake sort is a sorting algorithm that sorts a sequence by repeatedly flipping the elements.
 * In each iteration, it finds the maximum element and flips the subsequence from the first element
 * up to the maximum element.
 * This process is repeated until the sequence is sorted.
 *
 * Worst-case performance:       O(n^2)
 * Best-case performance:        O(n)
 * Average performance:          O(n^2)
 * Worst-case space complexity:  O(1)
 */
data object PancakeSort : Sortable {
    /**
     * Performs the pancake sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        for (i in arr.indices) {
            var max = arr[0]
            var index = 0

            for (j in 0 until arr.size - i) {
                if (max < arr[j]) {
                    max = arr[j]
                    index = j
                }
            }
            arr.flip(index, arr.size - 1 - i)
        }
    }
}
