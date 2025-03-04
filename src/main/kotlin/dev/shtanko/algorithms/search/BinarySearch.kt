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

package dev.shtanko.algorithms.search

/**
 * Implementation of the binary search algorithm using iteration.
 *
 * In computer science, binary search, also known as half-interval search, logarithmic search, or binary chop, is a
 * search algorithm that finds the position of a target value within a sorted array.
 * Binary search compares the target value to the middle element of the array.
 *
 * Worst-case performance       O(log(n))
 * Best-case performance        O(1)
 * Average performance          O(log(n))
 * Worst-case space complexity  O(1)
 *
 * @param T The type of elements in the array, must be comparable.
 */
class BinarySearch<T : Comparable<T>> : Searchable<T> {
    /**
     * Performs the binary search operation on the given array to find the index of the specified element.
     *
     * @param arr The array to search.
     * @param element The element to search for.
     * @return The index of the element in the array, or -1 if the element is not found.
     */
    override operator fun invoke(
        arr: Array<T>,
        element: T,
    ): Int {
        var low = 0
        var high = arr.size - 1
        while (low <= high) {
            val mid = (low + high) / 2
            when {
                element < arr[mid] -> high = mid - 1
                element > arr[mid] -> low = mid + 1
                else -> return mid
            }
        }
        return -1
    }
}
