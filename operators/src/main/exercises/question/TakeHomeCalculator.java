package question;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * - Fix the IntelliJ warnings with the file
 * - Introduce an operator function plus() on Money
 * - Introduce an operator function minus() on Money
 * - Encapsulate the percent value in a data class, and implement an operator function times() on Money which receives it
 * - Replace the for loop with a functional construct which sums the monies
 */
class TakeHomeCalculator {

    private final int percent;

    TakeHomeCalculator(int percent) {
        this.percent = percent;
    }

    Money netAmount(Money first, Money... rest) {

        List<Money> pairs = Arrays.asList(rest);

        Money total = first;

        for (Money next : pairs) {
            if (next.currency != total.currency) {
                throw new Incalculable();
            }
        }

        for (Money next : pairs) {
            total = new Money(total.amount + next.amount, next.currency);
        }

        Double amount = total.amount * (percent / 100d);
        Money tax = new Money(amount.intValue(), first.currency);

        if (total.currency == tax.currency) {
            return new Money(total.amount - tax.amount, first.currency);
        } else {
            throw new Incalculable();
        }
    }

    static class Money {
        @NotNull
        final Integer amount;
        final String currency;

        Money(@NotNull Integer amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }
    }
}
