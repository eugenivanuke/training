package executor;

import messageSystem.Address;
import messageSystem.MessageSystem;
import messageSystem.Subscriber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by clr on 06.01.2017.
 */
public class Executor implements Runnable, Subscriber {
    private final MessageSystem messageSystem;
    private final ExecutorService threadPool = Executors.newCachedThreadPool();
    private Address address;

    public Executor(MessageSystem messageSystem){
        this.messageSystem = messageSystem;
        this.address = new Address();
        messageSystem.addSubscriber(this);
    }

    public synchronized void addTask(Runnable task) {
        threadPool.submit(task);
    }

    @Override
    public synchronized Address getAddress() {
        return this.address;
    }

    @Override
    public void run() {
        java.util.logging.Logger.getGlobal().info("Executor thread running");
        while(true){
            messageSystem.execBySubscriber(this);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
