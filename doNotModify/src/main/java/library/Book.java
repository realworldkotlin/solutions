package library;

import java.util.Objects;

public class Book {

    public final String isbn;
    public final String title;
    public final Author author;
    public final int year;

    public Book(String isbn, String title, Author author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
            Objects.equals(isbn, book.isbn) &&
            Objects.equals(title, book.title) &&
            Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(isbn, title, author, year);
    }
}
