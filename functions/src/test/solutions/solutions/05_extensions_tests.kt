package solutions

import org.junit.Assert.assertEquals
import org.junit.Test
import toCamelCase

class ExtensionTests {

    @Test
    fun `converts to camel case`() {
        assertEquals(toCamelCase("my first extension"), "MyFirstExtension")
    }

}