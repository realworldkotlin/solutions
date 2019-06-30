package library;

import java.util.List;

public class Catalogue {
    private final List<Book> books;

    public Catalogue(List<Book> books) {
        this.books = books;
    }

    public Book lookup(String isbn) {
        return books.stream().filter(it -> it.isbn.equals(isbn)).findFirst().orElse(null);
    }
}
