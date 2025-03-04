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

package dev.shtanko.algorithms.sorts

fun interface ToStringStrategy {
    fun invoke(obj: TestObject): String
}

data object FullToStringStrategy : ToStringStrategy {
    override fun invoke(obj: TestObject): String = "TestObject(id=${obj.id}, name=${obj.name})"
}

data object NameToStringStrategy : ToStringStrategy {
    override fun invoke(obj: TestObject): String = obj.name
}

/**
 * @property id
 * @property name
 */
data class TestObject(
    val id: Int,
    val name: String,
    val strategy: ToStringStrategy = NameToStringStrategy,
) : Comparable<TestObject> {
    override fun compareTo(other: TestObject): Int {
        val n = this.name.compareTo(other.name)
        return if (n == 0) this.id.compareTo(other.id) else n
    }

    companion object {
        fun empty(
            strategy: ToStringStrategy = NameToStringStrategy,
        ): TestObject = TestObject(0, "", strategy)
    }

    override fun toString(): String = strategy.invoke(this)
}
