import org.junit.Assert.assertEquals
import org.junit.Test

class CharacterReaderTest {

    @Test
    fun `reads set of characters from file`() {
        val expected = """!()*,-.:;?ABCDEFGHIKLMNOPRSTUVWYZ[abcdefghijklmnopqrstuvwxyz‘’“”"""
        val actual = CharacterReader().readCharactersFrom("src/test/resources/alice.txt")
                .filter { !it.isWhitespace() }.joinToString("")
        assertEquals("sorted list of characters", expected, actual)
    }
}
