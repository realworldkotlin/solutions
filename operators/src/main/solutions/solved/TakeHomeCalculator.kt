package solved

data class Money(val value: Int, val currency: String)

internal class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        rest.find { it.currency !== first.currency }?.let { throw Incalculable() }
        val total = rest.fold(first) { memo, next -> memo + next }
        return total - total * percent
    }
}

operator fun Money.minus(that: Money) = Money(value - that.value, currency)
operator fun Money.plus(that: Money) = Money(value + that.value, currency)
operator fun Money.times(percent: Int) = Money((value * (percent / 100.0)).toInt(), currency)
