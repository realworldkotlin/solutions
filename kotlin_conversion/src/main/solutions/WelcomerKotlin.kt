class WelcomerKotlin private constructor(private val message: String?) {

    init {
        println("Welcome to Real World $message")
    }

    private fun printEachCharacter() =
        if (message != null) {
            message.printCharacters()
            "Go $message!"
        } else "No message"

    private fun String.printCharacters() =
        toUpperCase().toCharArray().forEach { part -> println("Give me a $part!") }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val finalMessage = WelcomerKotlin("Kotlin").printEachCharacter()
            println(finalMessage)
        }
    }
}
