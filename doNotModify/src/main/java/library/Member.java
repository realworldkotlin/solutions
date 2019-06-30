package library;

import java.util.Objects;

public class Member {

    public final int id;
    public final String firstName;
    public final String lastName;

    public Member(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
            Objects.equals(firstName, member.firstName) &&
            Objects.equals(lastName, member.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName);
    }
}
