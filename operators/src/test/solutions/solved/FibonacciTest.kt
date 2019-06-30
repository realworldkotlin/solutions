package solved

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class FibonacciTest {
    @Test
    fun `calculate Fibonacci`() {
        assertThat(Fibonacci(0).result, equalTo(1))
        assertThat(Fibonacci(1).result, equalTo(1))
        assertThat(Fibonacci(2).result, equalTo(2))
        assertThat(Fibonacci(3).result, equalTo(3))
        assertThat(Fibonacci(4).result, equalTo(5))
    }


    @Test
    fun `implement comparable`() {
        assertThat(Fibonacci(0) < Fibonacci(2), equalTo(true))
    }


    @Test
    fun `calculate the first 5 fibonacci numbers`() {
        assertThat(
            (Fibonacci(0)..Fibonacci(5)).map { it.result }.joinToString(),
                equalTo("1, 1, 2, 3, 5")
        )
    }

}