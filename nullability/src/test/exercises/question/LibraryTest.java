package question;

import java.time.Clock;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import library.Author;
import library.Authors;
import library.Book;
import library.Catalogue;
import library.Loan;
import library.Loans;
import library.Member;
import library.Members;
import org.junit.Test;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private final Author author1 = new Author(1, "Roger", "Hargreaves", 1935);
    private final Author author2 = new Author(2, "Billy", "Nomates", 2000);
    private final Author author3 = new Author(3, "Gerald", "Smith", 1996);
    private final Book book1 = new Book("isbn1", "Mr Grumpy", author1, 2000);
    private final Book book2 = new Book("isbn2", "Mr Clownface", author1, 2004);
    private final Book book3 = new Book("isbn3", "Mr Ecstatic", author2, 1999);
    private final Member member = new Member(123, "Bob", "Builder");

    private final Library library = new Library(
        new Members(singletonList(member)),
        new Catalogue(Arrays.asList(book1, book2, book3)),
        new Authors(Arrays.asList(author1, author2, author3)), new Loans(Clock.fixed(Instant.EPOCH, ZoneId.systemDefault()), 7));

    @Test
    public void borrower_can_borrow_book() {
        assertEquals(new Loan(book1, member.id, Period.ofDays(7)), library.borrow(member.id, book1.isbn));
    }

    @Test
    public void borrower_cannot_borrow_more_than_2_books() {
        library.borrow(member.id, book1.isbn);
        library.borrow(member.id, book2.isbn);
        assertEquals(null, library.borrow(member.id, book3.isbn));
    }

    @Test
    public void youngAuthorsAreReturned() {
        library.borrow(member.id, book1.isbn);
        library.borrow(member.id, book3.isbn);
        assertEquals(Collections.singletonList(author2), library.popularYoungAuthors());
    }

    @Test
    public void whenThereAreNoLoansNoAuthorsAreReturned() {
        assertEquals(null, library.popularYoungAuthors());
    }
}
