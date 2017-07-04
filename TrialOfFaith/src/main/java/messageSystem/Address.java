package messageSystem;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by clr on 06.01.2017.
 */
public class Address {
    private static AtomicInteger subscriberIdCreator = new AtomicInteger();
    private final int subscriberId;

    public Address() {
        this.subscriberId = subscriberIdCreator.incrementAndGet();
    }

    public int hashCode() {
        return subscriberId;
    }

    public boolean equals(Address address) {
        boolean equals = false;
        if (this.subscriberId == address.subscriberId)
            equals = true;
        return equals;
    }
}
