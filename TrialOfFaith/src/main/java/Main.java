import executor.Executor;
import messageSystem.MessageSystem;
import tasks.SocketListener;

import java.io.IOException;


/**
 * Created by clr on 28.12.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        MessageSystem messageSystem = new MessageSystem();

        Executor executor = new Executor(messageSystem);
        Thread executorThread = new Thread(executor);
        executorThread.setName("Executor");

        executorThread.start();
        executor.addTask(new SocketListener(messageSystem, executor));

    }
}
