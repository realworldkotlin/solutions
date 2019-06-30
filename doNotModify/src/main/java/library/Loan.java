package library;

import java.time.Period;
import java.util.Objects;

public class Loan {
    public final Book book;
    public final int membershipNumber;
    public final Period period;

    public Loan(Book book, int membershipNumber, Period period) {
        this.book = book;
        this.membershipNumber = membershipNumber;
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return membershipNumber == loan.membershipNumber &&
            Objects.equals(book, loan.book) &&
            Objects.equals(period, loan.period);
    }

    @Override
    public int hashCode() {

        return Objects.hash(book, membershipNumber, period);
    }
}
