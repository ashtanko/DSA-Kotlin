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

package dev.shtanko.algorithms.extensions

/**
 * Swaps elements at the specified indices in the array.
 *
 * @param i The index of the first element to swap.
 * @param j The index of the second element to swap.
 */
fun <T> Array<T>.swap(
    i: Int,
    j: Int,
) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

/**
 * Swaps elements at the specified indices in the IntArray.
 *
 * @param i The index of the first element to swap.
 * @param j The index of the second element to swap.
 */
fun IntArray.swap(
    i: Int,
    j: Int,
) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

/**
 * Reverses the elements in the array in place.
 */
fun <T> Array<T>.reverse() {
    val arraySize = this.size
    for (startIndex in 0 until arraySize / 2) {
        this.swap(startIndex, arraySize - 1 - startIndex)
    }
}

/**
 * Reverses the elements in the array in place using two pointers.
 */
fun <T> Array<T>.reverse2() {
    var i = 0
    var j = size - 1
    while (i < j) {
        swap(i, j)
        i++
        j--
    }
}

/**
 * Flips the elements in the array between the specified indices in place.
 *
 * @param leftIndex The starting index (inclusive) of the portion to flip.
 * @param rightIndex The ending index (inclusive) of the portion to flip.
 */
fun <T> Array<T>.flip(
    leftIndex: Int,
    rightIndex: Int,
) {
    var left = leftIndex
    var right = rightIndex
    while (left <= right) {
        swap(left++, right--)
    }
}

/**
 * Returns the second element of the IntArray.
 *
 * @return The second element of the IntArray.
 * @throws NoSuchElementException if the array is empty.
 */
fun IntArray.second(): Int {
    if (isEmpty()) {
        throw NoSuchElementException("Array is empty.")
    }
    return this[1]
}

/**
 * Finds the index of the minimum element in the array starting from the
 * specified index.
 *
 * @param i The starting index from which to search for the minimum element.
 * @return The index of the minimum element found in the array starting from the
 * specified index.
 */
fun <T : Comparable<T>> Array<T>.findMinimumIndex(i: Int): Int {
    var min = i
    for (j in i + 1 until this.size) {
        if (this[j] < this[min]) {
            min = j
        }
    }
    return min
}
