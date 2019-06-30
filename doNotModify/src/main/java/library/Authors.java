package library;

import java.util.Iterator;
import java.util.List;

public class Authors implements Iterable<Author> {

    private final List<Author> authors;

    public Authors(List<Author> authors) {
        this.authors = authors;
    }

    public Author lookup(int id) {
        return authors.stream().filter(a -> a.id == id).findFirst().orElse(null);
    }

    public Iterator<Author> iterator() {
        return authors.iterator();
    }
}
