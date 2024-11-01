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

package dev.shtanko.algorithms.utils

import dev.shtanko.algorithms.sorts.Sortable
import java.util.Locale
import java.util.concurrent.TimeUnit
import kotlin.system.measureNanoTime
import kotlin.time.DurationUnit
import kotlin.time.toTimeUnit

/**
 * Measures the execution time of a task using the specified `unit` for the result.
 *
 * @param unit The desired time unit for the result.
 * @param task The task to measure the execution time of.
 * @return The elapsed time in the specified time unit.
 */
fun measureTime(
    unit: DurationUnit,
    task: () -> Unit,
): Long = unit.toTimeUnit().convert(measureNanoTime(task), TimeUnit.NANOSECONDS)

/**
 * Measures the execution time of a task and prints the result.
 * The task is associated with a strategy and an array length.
 *
 * @param strategy The strategy associated with the task.
 * @param array The array associated with the task.
 * @param task The task to measure the execution time of.
 */
@Suppress("DEBUG_PRINT")
fun measureTime(
    strategy: Sortable,
    array: IntArray,
    task: () -> Unit,
) {
    val elapsed = measureTime(DurationUnit.MILLISECONDS, task)
    println(
        String.format(
            Locale.getDefault(),
            "Arrays of length %d Strategy %s Consumed time: %d ms",
            array.size,
            strategy::class.java.simpleName,
            elapsed,
        ),
    )
}

/**
 * Measures the execution time of a task and prints the result.
 *
 * @param taskName The name of the task.
 * @param task The task to measure the execution time of.
 */
@Suppress("DEBUG_PRINT")
fun measureTime(
    taskName: String,
    task: () -> Unit,
) {
    val elapsed = measureTime(DurationUnit.MILLISECONDS, task)
    println(String.format(Locale.getDefault(), "Task %s Consumed time: %d ms", taskName, elapsed))
}
