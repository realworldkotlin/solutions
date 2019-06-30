package solved

import Direction

data class Ship(val direction: Direction?, val length: Int, val row: Int, val column: Int, val isDestroyed: Boolean) {

    constructor(direction: Direction, length: Int) : this(direction, length, 0, 0, false)

    fun destroy(): Ship = copy(isDestroyed = true)
    val coordinates: Pair<Int, Int> = row to column
}
