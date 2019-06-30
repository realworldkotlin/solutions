package library;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

import static java.util.stream.Collectors.toList;

public class Loans implements Iterable<Loan> {

    private final Clock clock;
    private final int loanPeriodInDays;
    private final List<Loan> loans = new ArrayList<>();

    public Loans(Clock clock, int loanPeriodInDays) {
        this.clock = clock;
        this.loanPeriodInDays = loanPeriodInDays;
    }

    public List<Loan> lentTo(Member member) {
        return loans.stream()
            .filter(l -> l.membershipNumber == member.id)
            .collect(toList());
    }

    public Loan lend(int membershipNumber, Book book) {
        LocalDate now = LocalDate.now(clock);
        Loan newLoan = new Loan(book, membershipNumber, Period.between(now, now.plusDays(loanPeriodInDays)));
        loans.add(newLoan);
        return newLoan;
    }

    @NotNull
    @Override
    public Iterator<Loan> iterator() {
        return loans.iterator();
    }
}
