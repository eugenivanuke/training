package messageSystem.msg;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by clr on 09.12.2016.
 */
public class Address {
    private static AtomicInteger abonentIdCreator = new AtomicInteger();
    private final int abonentId;

    public Address () {
        this.abonentId = abonentIdCreator.incrementAndGet();
    }

    public int hashCode() {
        return abonentId;
    }

    public boolean equals(int abonentId) {
        if (this.abonentId == abonentId) return true;
        else return false;
    }
}
