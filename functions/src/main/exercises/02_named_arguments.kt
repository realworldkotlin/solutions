fun sayHelloAgain(name: String, addExclamation: Boolean, addQuestionMark: Boolean, capitalise: Boolean): String {
    val toPrint = name
        .let { if (addExclamation) it + "!" else it }
        .let { if (addQuestionMark) it + "?" else it }
        .let { if (capitalise) it.toUpperCase() else it }

    return "Hello, $toPrint"
}
