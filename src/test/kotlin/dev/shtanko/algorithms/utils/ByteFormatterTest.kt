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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ByteFormatterTest {

    @Test
    fun testBinByteFormatter() {
        assertEquals("0.0 BB", binByteFormatter(0.0, 'B'))
        assertEquals("-1023.0 BB", binByteFormatter(-1023.0, 'B'))
        assertEquals("1023.0 BB", binByteFormatter(1023.0, 'B'))
        assertEquals("1024.0 iB", binByteFormatter(1024.0, 'i'))
        assertEquals("1572864.0 iB", binByteFormatter(1.5 * 1024 * 1024, 'i'))
        assertEquals("1073741824.0 iB", binByteFormatter(1.0 * 1024 * 1024 * 1024, 'i'))
        assertEquals("1099511627776.0 iB", binByteFormatter(1.0 * 1024 * 1024 * 1024 * 1024, 'i'))
    }

    @Test
    fun testSiByteFormatter() {
        assertEquals("0.0 BiB", siByteFormatter(0.0, 'B'))
        assertEquals("-999.0 BiB", siByteFormatter(-999.0, 'B'))
        assertEquals("999.0 BiB", siByteFormatter(999.0, 'B'))
        assertEquals("1000.0 BiB", siByteFormatter(1000.0, 'B'))
        assertEquals("1500000.0 BiB", siByteFormatter(1.5 * 1000 * 1000, 'B'))
        assertEquals("1000000000.0 BiB", siByteFormatter(1.0 * 1000 * 1000 * 1000, 'B'))
        assertEquals("1000000000000.0 BiB", siByteFormatter(1.0 * 1000 * 1000 * 1000 * 1000, 'B'))
    }
}
