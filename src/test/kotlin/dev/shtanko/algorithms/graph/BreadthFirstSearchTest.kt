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

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.support.ParameterDeclarations
import java.util.stream.Stream

class BreadthFirstSearchTest {

    @DisplayName("BFS Test")
    @ParameterizedTest(name = "{0} graph: {1}, start: {2}, expected: {3}")
    @ArgumentsSource(InputArgumentsProvider::class)
    @Suppress("UnusedParameter")
    fun `bfs test`(
        name: String,
        graph: Graph,
        start: Int,
        expected: List<Int>,
    ) {
        val actual = BreadthFirstSearch(graph, start)
        assertThat(actual).isEqualTo(expected)
    }

    class InputArgumentsProvider : ArgumentsProvider {
        @Suppress("LongMethod")
        override fun provideArguments(
            parameters: ParameterDeclarations?,
            context: ExtensionContext?
        ): Stream<out Arguments> = Stream.of(
            arguments(
                "should return empty list for empty",
                EmptyGraph,
                0,
                emptyList<Int>(),
            ),
            arguments(
                "should return single node for single node",
                graphOf(0 to emptyList<Int>()),
                0,
                listOf(0),
            ),
            arguments(
                "should return nodes in correct order for simple",
                graphOf(
                    0 to listOf(1, 2),
                    1 to emptyList(),
                    2 to emptyList(),
                ),
                0,
                listOf(0, 1, 2),
            ),
            arguments(
                "should handle disconnected components",
                graphOf(
                    0 to listOf(1),
                    1 to listOf(2),
                    3 to emptyList(), // Isolated node
                ),
                0,
                listOf(0, 1, 2),
            ),
            arguments(
                "should handle nodes with no neighbors",
                graphOf(
                    0 to emptyList(),
                    1 to emptyList(), // Isolated node
                ),
                0,
                listOf(0),
            ),
            arguments(
                "should handle cycles in",
                graphOf(
                    0 to listOf(1, 2),
                    1 to listOf(2),
                    2 to listOf(3),
                    3 to listOf(0),
                ),
                0,
                listOf(0, 1, 2, 3),
            ),
            arguments(
                "should handle start node not being 0",
                graphOf(
                    0 to listOf(1, 2),
                    1 to listOf(2),
                    2 to listOf(3),
                    3 to listOf(0),
                ),
                0,
                listOf(0, 1, 2, 3),
            ),
            arguments(
                "should handle start node not being in the graph",
                graphOf(
                    0 to listOf(1, 2),
                    1 to listOf(3),
                    2 to listOf(4),
                    3 to emptyList(),
                    4 to emptyList(),
                ),
                5,
                emptyList<Int>(),
            ),
        )
    }
}
