package services.taskExecutor;

import messageSystem.MessageSystem;
import messageSystem.msg.Abonent;
import messageSystem.msg.Address;
import services.socketListener.SocketListener;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by clr on 10.12.2016.
 */
public class TaskExecutor implements Executor, Runnable, Abonent {
    private final ExecutorService threadPool;
    private final MessageSystem messageSystem;
    private Address address;

    public TaskExecutor(MessageSystem messageSystem) {
        this.threadPool = Executors.newCachedThreadPool();
        this.messageSystem = messageSystem;
        this.address = new Address();
    }

    @Override
    public void execute(Runnable task) {
        this.threadPool.submit(task);
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public void run() {
        while(true) {
            messageSystem.execForAbonent(this);
            try {
                Thread.sleep(100);
            } catch (Exception e){
                e.getStackTrace();
            }
        }
    }
}
