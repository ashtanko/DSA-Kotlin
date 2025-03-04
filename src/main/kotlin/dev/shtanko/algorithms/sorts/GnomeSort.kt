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
 * Gnome sort is a simple sorting algorithm that works by repeatedly moving an element one position
 * towards its correct position in the sorted part of the array. It does this by comparing adjacent
 * elements and swapping them if they are in the wrong order. This process is continued until the
 * entire array is sorted. The algorithm gets its name from the idea that a gnome always moves the
 * flower pots to put them in the correct order.
 *
 * Worst-case performance:       O(n^2)
 * Best-case performance:        O(n)
 * Average performance:          O(n^2)
 * Worst-case space complexity:  O(1)
 */
data object GnomeSort : Sortable {
    /**
     * Performs the gnome sort operation on the given array.
     *
     * @param arr The array to sort.
     * @param T The type of elements in the array, must be comparable.
     */
    override fun <T : Comparable<T>> invoke(arr: Array<T>) {
        var i = 1
        var j = 2
        while (i < arr.size) {
            if (arr[i - 1] < arr[i]) {
                i = j++
            } else {
                arr.swap(i - 1, i)
                if (--i == 0) {
                    i = j++
                }
            }
        }
    }
}
