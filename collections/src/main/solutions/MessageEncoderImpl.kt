class MessageEncoderImpl {
    private val vowels = setOf('a', 'e', 'i', 'o', 'u', ' ')

    fun encode(messages: List<String>): List<String> = messages
        .filter { it.length > 10 }
        .map(String::toLowerCase)
        .map { message ->
            message
                .groupBy { it }
                .filterKeys { it -> !vowels.contains(it) }
                .map { (c, list) -> "$c${list.size}" }
                .sorted()
                .joinToString(" ")
        }
}
