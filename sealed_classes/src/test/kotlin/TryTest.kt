// uncomment these tests as you go!
class TryTest {
//    private val success = Try { 123 }
//
//    private val exception = Exception("999")
//
//    private val failure = Try<Int> { throw exception }
//
//    @Test
//    fun `invoke`() {
//        assertEquals(Success(123), success)
//        assertEquals(Failure<Int>(exception), failure)
//    }
//
//    @Test
//    fun `orThrow success`() {
//        assertEquals(123, success.orThrow())
//    }
//
//    @Test(expected = Exception::class)
//    fun `orThrow failure`() {
//        failure.orThrow()
//    }
//
//    @Test
//    fun `map`() {
//        assertEquals(Success(246), success.map { it + it })
//        assertEquals(failure, failure.map { it + it })
//    }
//
//    @Test
//    fun `flatMap`() {
//        assertEquals(Success(369), success.flatMap { Success(it + it + it) })
//        assertEquals(failure, failure.flatMap { Success(it + it + it) })
//    }
//
//    @Test
//    fun `mapError`() {
//        assertEquals(success, success.mapError { it.message!!.toInt() })
//        assertEquals(Success(999), failure.mapError { it.message!!.toInt() })
//    }
//
//    @Test
//    fun `flatMapError`() {
//        assertEquals(success, success.flatMapError { Success(it.message!!.toInt()) })
//        assertEquals(Success(999), failure.flatMapError { Success(it.message!!.toInt()) })
//    }
//
//    @Test
//    fun `iterable`() {
//        assertEquals(listOf(123), success.iterator().asSequence().toList())
//        assertEquals(emptyList<String>(), failure.iterator().asSequence().toList())
//    }
}