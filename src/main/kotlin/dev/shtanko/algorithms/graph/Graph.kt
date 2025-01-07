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

/**
 * A graph is a collection of nodes (vertices) along with identified pairs of
 * nodes (called edges, links, etc.).
 * The graph is one of the most common data structures in computer science.
 */
typealias Graph = Map<Int, List<Int>>

/**
 * An empty graph.
 */
data object EmptyGraph : Graph by graphOf()

/**
 * Creates a graph from the specified pairs.
 * The first value in the pair is the node, and the second value is the list
 * of neighbors.
 * The neighbors are the nodes that are connected to the current node.
 *
 * @param pairs The pairs of nodes and their neighbors.
 * @return The created graph.
 */
fun graphOf(vararg pairs: Pair<Int, List<Int>>): Graph = pairs.toMap()
