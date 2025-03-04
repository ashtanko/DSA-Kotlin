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

package dev.shtanko.algorithms

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstantsTest {
    @Test
    fun `constants test`() {
        assertEquals(10, DECIMAL)
        assertEquals(8, OCTAL)
        assertEquals(16, HEXADECIMAL)
        assertEquals(65535, SHUFFLE)
        assertEquals(1_000_000_007, MOD)
        assertEquals(1_000_000_000.0, BILLION)
        assertEquals(0.00001, EPSILON)
        assertEquals(1024, BYTE)
        assertEquals(1000L, MILLISECOND)
        assertEquals("%.1f %cB", BIN_FORMAT)
        assertEquals("%.1f %ciB", SI_FORMAT)
        assertEquals(26, ALPHABET_LETTERS_COUNT)
    }
}
