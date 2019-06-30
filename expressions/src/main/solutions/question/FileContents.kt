package question

import java.io.File
import java.io.IOException

class FileContents {
    @Throws(IOException::class)
    fun contentsOf(csvFileNames: String): List<String> = csvFileNames.split(",")
        .map { fileName ->
            fileName.let {
                if (!it.endsWith(".txt")) File(it + ".txt") else File(it)
            }.let {
                    fileName + ":" + if (!it.exists()) {
                        try {
                            it.createNewFile()
                            println("creating " + it.absolutePath)
                            "<empty>"
                        } catch (e: IOException) {
                            "<could not create>"
                        }
                    } else {
                        it.readLines().joinToString(",")
                    }
                }
        }
}
