private fun externalPrintNumbers(numbers: List<Number>): String = numbers.joinToString(" -> ")

fun printNumbers(value: Number): String {
    return externalPrintNumbers(listOf(value))
}

fun printNumbers(firstValue: Number, secondValue: Number): String {
    return externalPrintNumbers(listOf(firstValue, secondValue))
}

fun printNumbers(firstValue: Number, secondValue: Number, thirdValue: Number): String {
    return externalPrintNumbers(listOf(firstValue, secondValue, thirdValue))
}
