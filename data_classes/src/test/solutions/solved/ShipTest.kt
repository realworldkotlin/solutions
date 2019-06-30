package solved

import Direction
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class ShipTest {

    @Test
    fun `destructuring`() {
        val (direction, length) = Ship(Direction.VERTICAL, 3)

        assertThat(direction, equalTo(Direction.VERTICAL))
        assertThat(length, equalTo(3))
    }
}