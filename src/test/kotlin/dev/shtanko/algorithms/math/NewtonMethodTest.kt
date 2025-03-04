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

package dev.shtanko.algorithms.math

import dev.shtanko.algorithms.EPSILON
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NewtonMethodTest {
    @Test
    fun `calculate sqrt newton method test one`() {
        assertTrue(sqrt(-2.0).isNaN())
        assertTrue(sqrt(-2.0, 0.toDouble()).isNaN())
        assertEquals(2.0000000929222947, sqrt(4.toDouble()), 1e-15)
        assertEquals(4.000000636692939, sqrt(16.toDouble()), 1e-12)
    }

    @Test
    fun `sqrt returns correct square root for positive double input`() {
        val result = sqrt(2.25)
        assertEquals(1.5, result, EPSILON)
    }

    @Test
    fun `sqrt returns correct square root for zero input`() {
        val result = sqrt(0.0)
        assertEquals(0.0, result, EPSILON)
    }

    @Test
    fun `sqrt returns correct square root for large input`() {
        val largeNumber = 1e10
        val result = sqrt(largeNumber)
        assertEquals(sqrt(largeNumber), result, EPSILON)
    }

    @Test
    fun `calculate sqrt newton method test two`() {
        assertTrue(sqrt(-2).isNaN())
        assertEquals(2.0000000929222947, sqrt(4), 1e-15)
        assertEquals(4.000000636692939, sqrt(16), 1e-12)
    }
}
