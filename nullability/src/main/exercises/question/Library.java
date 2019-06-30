package question;

import java.util.ArrayList;
import java.util.List;
import library.Author;
import library.Authors;
import library.Book;
import library.Catalogue;
import library.Loan;
import library.Loans;
import library.Member;
import library.Members;

public class Library {

    private final Members members;
    private final Catalogue catalogue;
    private final Authors authors;
    private final Loans loans;

    public Library(Members members, Catalogue catalogue, Authors authors, Loans loans) {
        this.members = members;
        this.catalogue = catalogue;
        this.authors = authors;
        this.loans = loans;
    }

    public Loan borrow(int membershipNumber, String isbn) {
        Member member = members.lookup(membershipNumber);
        if (member != null) {
            List<Loan> current = loans.lentTo(member);

            Book book = catalogue.lookup(isbn);
            if (book != null) {
                if (current.size() > 1) {
                    return null;
                } else {
                    return loans.lend(membershipNumber, book);
                }
            }
        }
        return null;
    }

    public List<Author> popularYoungAuthors() {
        List<Author> youngAuthors = new ArrayList<>();
        for (Member member : members) {
            List<Loan> lent = loans.lentTo(member);
            for (Loan loan : lent) {
                Author a = authors.lookup(loan.book.author.id);
                if (a != null && a.birthYear > 1995) {
                    youngAuthors.add(a);
                }
            }
        }
        if (youngAuthors.isEmpty()) return null;
        else return youngAuthors;
    }
}
