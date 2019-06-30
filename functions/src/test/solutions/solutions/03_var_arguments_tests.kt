package solutions

import org.junit.Assert.assertEquals
import org.junit.Test
import printNumbers

class VarArgumentsTests {

    @Test
    fun `can print with various number of arguments`() {
        assertEquals(printNumbers(1), "1")
        assertEquals(printNumbers(1, 2), "1 -> 2")
        assertEquals(printNumbers(1, 2, 3), "1 -> 2 -> 3")
    }

    @Test
    fun `use spread operator from list`() {
//        val numbers = listOf(1, 2, 3)
//        assertEquals(???, "1 -> 2 -> 3")
    }

    @Test
    fun `use spread operator from array`() {
//        val numbers = arrayOf(1, 2, 3)
//        assertEquals(???, "1 -> 2 -> 3")
    }
}