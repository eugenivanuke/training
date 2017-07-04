package messageSystem;

import messageSystem.msg.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by clr on 06.01.2017.
 */
public class MessageSystem {
    private Map<Address, ConcurrentLinkedQueue<Message>> messages =
            new HashMap<Address, ConcurrentLinkedQueue<Message>>();

    public MessageSystem(){

    }

    public void addSubscriber(Subscriber subscriber) {
        messages.put(subscriber.getAddress(), new ConcurrentLinkedQueue<Message>());
    }

    public synchronized Map<Address, ConcurrentLinkedQueue<Message>> getMessages(){
        return this.messages;
    }

    public synchronized void sendMessage(Message message) {
        Queue<Message> messageQueue = messages.get(message.getWhom());
        messageQueue.add(message);
    }


    public synchronized void execBySubscriber(Subscriber subscriber){
        Queue<Message> messageQueue = messages.get(subscriber.getAddress());
        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();
            message.exec(subscriber);
        }
    }
}
