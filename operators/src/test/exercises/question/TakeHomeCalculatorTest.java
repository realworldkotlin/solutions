package question;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TakeHomeCalculatorTest {

    @Test
    public void canCalculateTax() {
        Integer first = new TakeHomeCalculator(10).netAmount(new TakeHomeCalculator.Money(40, "GBP"), new TakeHomeCalculator.Money(50, "GBP"), new TakeHomeCalculator.Money(60, "GBP")).amount;
        assertEquals(135, first.intValue());
    }

    @Test(expected = Incalculable.class)
    public void cannotSumDifferentCurrencies() {
        new TakeHomeCalculator(10).netAmount(new TakeHomeCalculator.Money(4, "GBP"), new TakeHomeCalculator.Money(5, "USD"));
    }
}
