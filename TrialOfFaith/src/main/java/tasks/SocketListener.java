package tasks;

import executor.Executor;
import messageSystem.Address;
import messageSystem.MessageSystem;
import messageSystem.Subscriber;
import messageSystem.msg.messageToExecutor.MsgServe;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by clr on 10.01.2017.
 */
public class SocketListener implements Runnable, Subscriber {
    private Address address;
    private final MessageSystem messageSystem;
    private final Executor executor;

    public SocketListener(MessageSystem messageSystem, Executor executor){
        this.address = new Address();
        this.executor = executor;
        this.messageSystem = messageSystem;
    }

    @Override
    public synchronized Address getAddress() {
        return this.address;
    }

    @Override
    public void run() {
        java.util.logging.Logger.getGlobal().info("Listening in port 5060");
        try (ServerSocket serverSocket = new ServerSocket(5060))
        {
            while(true) {
                Socket socket = serverSocket.accept();
                java.util.logging.Logger.getGlobal().info("Got a connection");
                messageSystem.sendMessage(new MsgServe(
                        this.getAddress(), executor.getAddress(), socket));
                java.util.logging.Logger.getGlobal().info("MsgServe send");
            }
        } catch (IOException e) {
            System.err.println("Could not listen on that port");
            System.exit(-1);
        }
    }
}
