package library;

import java.util.Iterator;
import java.util.List;

public class Members implements Iterable<Member> {
    private final List<Member> members;

    public Members(List<Member> members) {
        this.members = members;
    }

    public Member lookup(int membershipNumber) {
        return members.stream()
            .filter(m -> m.id == membershipNumber)
            .findFirst()
            .orElse(null);
    }

    public Iterator<Member> iterator() {
        return members.iterator();
    }
}
