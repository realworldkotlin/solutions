import org.junit.Assert.assertEquals
import org.junit.Test

class DefaultParameters {

    @Test
    fun `default parameters`(){
        assertEquals(sayHello(), "Hello World!")
        assertEquals(sayHello("John"), "Hello John!")

        assertEquals(sayHelloTwice("Mary"), "Hello Mary! MARY?!")
        assertEquals(sayHelloTwice("Carl", "CA-CARL"), "Hello Carl! CA-CARL?!")
    }
}