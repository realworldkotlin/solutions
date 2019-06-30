fun countEach(words: List<String>) = words.map { it to it.length }

fun printOnePerLine(wordLengths: List<Pair<String, Int>>) = wordLengths.map { "${it.first} (${it.second})" }

fun printWordLengths(value: String): String {
    val words = value.split(" ")
    val wordLengths = countEach(words)
    val formatted = printOnePerLine(wordLengths)
    return formatted.joinToString("\n")
}
