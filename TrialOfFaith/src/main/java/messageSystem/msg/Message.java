package messageSystem.msg;

import messageSystem.Address;
import messageSystem.Subscriber;

/**
 * Created by clr on 06.01.2017.
 */
public abstract class Message {
    private final Address whom;
    private final Address fromWhom;

    public Message(Address fromWhom, Address whom){
        this.fromWhom = fromWhom;
        this.whom = whom;
    }

    public  Address getFromWhom(){
        return fromWhom;
    }

    public Address getWhom(){
        return whom;
    }

    public abstract void exec(Subscriber subscriber);
}
