import org.junit.Assert.assertEquals
import org.junit.Test

class NamedArgumentsTests {

    @Test
    fun `basic`() {
        assertEquals(sayHelloAgain("World",
            false,
            false,
            false), "Hello, World")
    }

    @Test
    fun `exclamation`() {
        assertEquals(sayHelloAgain("World",
            true,
            false,
            false), "Hello, World!")
    }

    @Test
    fun `question`() {
        assertEquals(sayHelloAgain("World",
            false,
            true,
            false), "Hello, World?")
    }

    @Test
    fun `capitalise`() {
        assertEquals(sayHelloAgain("World",
            false,
            false,
            true), "Hello, WORLD")
    }
}