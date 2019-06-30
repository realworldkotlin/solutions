// uncomment these tests as you go!
class EitherTest {
//    private val right = right("123")
//
//    private val left = left(123)
//
//    @Test
//    fun `right and left ok`() {
//        assertEquals(right.value, right.right())
//        assertEquals(left.value, left.left())
//    }
//
//    @Test(expected = Exception::class)
//    fun `right throws`() {
//        val right1: Any = left.right()
//        val value: Any = right.value
//        assertEquals(value, right1)
//    }
//
//    @Test(expected = Exception::class)
//    fun `left throws`() {
//        assertEquals(right.value, right.left())
//    }
//
//    @Test
//    fun `map`() {
//        assertEquals(right("123123"), right.map { it + it })
//        assertEquals(left, left.map { it + it })
//    }
//
//    @Test
//    fun `mapLeft`() {
//        assertEquals(right, right.mapLeft { it + it })
//        assertEquals(left(246), left.mapLeft { it + it })
//    }
//
//    @Test
//    fun `flatMap`() {
//        assertEquals(right("123123123"), right.flatMap { right(it + it + it) })
//        assertEquals(left, left.flatMap { right(it + it + it) })
//    }
//
//    @Test
//    fun `flatMapLeft`() {
//        assertEquals(right, right.flatMapLeft { right("" + it + it + it) })
//        assertEquals(right("123123123"), left.flatMapLeft { right("" + it + it + it) })
//    }
//
//    @Test
//    fun `iterable`() {
//        assertEquals(listOf("123"), right.iterator().asSequence().toList())
//        assertEquals(emptyList<String>(), left.iterator().asSequence().toList())
//    }
//
//    private fun left(value: Int) = Left<Int, String>(value)
//
//    private fun right(value: String) = Right<Int, String>(value)
}