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
 * Implementation of the linear search algorithm.
 *
 * Linear search is an algorithm which finds the position of a target value within an array (Usually unsorted)
 *
 * Worst-case performance       O(n)
 * Best-case performance        O(1)
 * Average performance          O(n)
 * Worst-case space complexity  O(1)
 *
 * @param T The type of elements in the array.
 */
class LinearSearch<T> : AbstractSearchStrategy<T> {

    /**
     * Performs the linear search operation on the given array to find the index of the specified element.
     *
     * @param arr The array to search.
     * @param element The element to search for.
     * @return The index of the element in the array, or -1 if the element is not found.
     */
    override fun perform(arr: Array<T>, element: T): Int {
        for ((i, a) in arr.withIndex()) {
            if (a == element) {
                return i
            }
        }
        return -1
    }
}
