package messageSystem;

import messageSystem.msg.Abonent;
import messageSystem.msg.Address;
import messageSystem.msg.Msg;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by clr on 09.12.2016.
 */
public class MessageSystem {
    private final Map<Address, ConcurrentLinkedQueue<Msg>> messages
            = new HashMap<Address, ConcurrentLinkedQueue<Msg>>();

    public MessageSystem() {

    }

    public void sendMessage(Msg message) {
        Queue<Msg> messageQueue = messages.get(message.getTo());
        messageQueue.add(message);
    }

    public void execForAbonent (Abonent abonent) {
        Queue<Msg> messageQueue = messages.get(abonent.getAddress());
        while(!messageQueue.isEmpty()) {
            Msg message = messageQueue.poll();
            message.exec(abonent);
        }
    }
}
