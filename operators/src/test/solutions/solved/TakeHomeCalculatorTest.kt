package solved

import org.junit.Assert
import org.junit.Test

class TakeHomeCalculatorTest {

    @Test
    fun canCalculateTax() {
        Assert.assertEquals(135, TakeHomeCalculator(10).netAmount(Money(40, "GBP"), Money(50, "GBP"), Money(60, "GBP")).value.toLong())
    }

    @Test(expected = Incalculable::class)
    fun cannotSumDifferentCurrencies() {
        TakeHomeCalculator(10).netAmount(Money(4, "GBP"), Money(5, "USD"))
    }
}

