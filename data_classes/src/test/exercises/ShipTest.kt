import Direction.HORIZONTAL
import Direction.VERTICAL
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class ShipTest {

    @Test
    fun `creation and access`() {
        val ship = Ship(VERTICAL, 2, 0, 1, false)

        assertThat(ship.direction, equalTo(VERTICAL))
        assertThat(ship.length, equalTo(2))
        assertThat(ship.row, equalTo(0))
        assertThat(ship.column, equalTo(1))
    }

    @Test
    fun equality() {
        assertThat(Ship(VERTICAL, 2, 0, 1, false), equalTo(Ship(VERTICAL, 2, 0, 1, false)))
    }

    @Test
    fun `secondary constructor`() {
        assertThat(Ship(VERTICAL, 2), equalTo(Ship(VERTICAL, 2, 0, 0, false)))
    }

    @Test
    fun `immutability`() {
        val initial = Ship(VERTICAL, 2, 0, 0, false)
        val destroyed = initial.destroy()

        assertThat(initial, not(equalTo(destroyed)))
        assertThat(initial.isDestroyed, equalTo(false))
        assertThat(destroyed.isDestroyed, equalTo(true))
    }

    @Test
    fun `string representation`() {
        assertThat(Ship(HORIZONTAL, 2, 0, 0, false).toString(), equalTo("Ship(direction=HORIZONTAL, length=2, row=0, column=0, destroyed=false)"))
    }

    @Test
    fun `destructured ship coordinate`() {
//        val (row, column) = Ship(HORIZONTAL, 1, 5, 7, false).coordinates
//        assertThat(row, equalTo(5))
//        assertThat(column, equalTo(7))
    }
}