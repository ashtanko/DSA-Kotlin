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

package dev.shtanko.algorithms.graph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GraphTest {
    @Test
    fun `emptyGraph should be empty`() {
        assertTrue(EmptyGraph.isEmpty())
    }

    @Test
    fun `graphOf should create a graph with the specified pairs`() {
        val graph = graphOf(
            1 to listOf(2, 3),
            2 to listOf(1, 4),
            3 to listOf(1),
            4 to listOf(2),
        )

        assertEquals(listOf(2, 3), graph[1])
        assertEquals(listOf(1, 4), graph[2])
        assertEquals(listOf(1), graph[3])
        assertEquals(listOf(2), graph[4])
    }

    @Test
    fun `graphOf should handle empty lists of neighbors`() {
        val graph = graphOf(
            1 to emptyList(),
            2 to listOf(1),
        )
        assertTrue(graph[1]?.isEmpty() == true)
        assertEquals(listOf(1), graph[2])
    }
}
