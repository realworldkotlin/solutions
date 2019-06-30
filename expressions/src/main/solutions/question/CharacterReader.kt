package question

import java.io.File
import java.io.FileReader

class CharacterReader {
    fun readCharactersFrom(filename: String): List<Char> = try {
        FileReader(File(filename)).use { reader ->
            reader.readText().toSet().sorted()
        }
     } catch (e: Exception) {
        emptyList()
     }
}
