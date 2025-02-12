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

import java.util.LinkedList

/**
 * Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures.
 * It starts at the tree root (or some arbitrary node of a graph, sometimes referred to as a 'search key')
 * and explores the neighbor nodes first, before moving to the next level neighbors.
 */
@Suppress("GENERIC_VARIABLE_WRONG_DECLARATION")
object BreadthFirstSearch : GraphTraverseStrategy {
    /**
     * Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures.
     * It starts at the tree root (or some arbitrary node of a graph, sometimes referred to as a 'search key')
     * and explores the neighbor nodes first, before moving to the next level neighbors.
     *
     * @param graph The graph to traverse.
     * @param start The starting node.
     * @return The list of nodes in the order they were visited.
     */
    override operator fun invoke(graph: Graph, start: Int): List<Int> {
        if (!graph.containsKey(start)) {
            return emptyList()
        }
        val queue = LinkedList<Int>()
        queue.offer(start)
        val visited = mutableSetOf<Int>()
        visited.add(start)
        val result = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val node = queue.poll() ?: return emptyList()
            result.add(node)

            graph[node]?.forEach { neighbor ->
                if (neighbor !in visited) {
                    queue.offer(neighbor)
                    visited.add(neighbor)
                }
            }
        }

        return result
    }
}
