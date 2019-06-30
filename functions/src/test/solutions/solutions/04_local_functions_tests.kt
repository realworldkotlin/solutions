package solutions

import org.junit.Assert.assertEquals
import org.junit.Test
import printWordLengths

class LocalFunctionsTests {

    @Test
    fun `print word lengths`() {
        assertEquals(printWordLengths("The quick brown fox jumps over a lazy dog"),
            """The (3)
quick (5)
brown (5)
fox (3)
jumps (5)
over (4)
a (1)
lazy (4)
dog (3)""".trimIndent())
    }

}