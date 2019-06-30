package library;

import java.util.Objects;

public class Author {

    public final int id;
    public final String firstName;
    public final String lastName;
    public final int birthYear;

    public Author(int id, String firstName, String lastName, int birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
            birthYear == author.birthYear &&
            Objects.equals(firstName, author.firstName) &&
            Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, birthYear);
    }
}
