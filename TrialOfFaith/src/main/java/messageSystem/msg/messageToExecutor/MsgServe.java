package messageSystem.msg.messageToExecutor;

import executor.Executor;
import messageSystem.Address;
import tasks.SocketProcessor;

import java.net.Socket;

/**
 * Created by clr on 06.01.2017.
 */
public class MsgServe extends MsgToExecutor {
    private final Socket socket;

    public MsgServe(Address fromWhom, Address whom, Socket socket) {
        super(fromWhom, whom);
        this.socket = socket;
    }

    public void exec(Executor executor){
        executor.addTask(new SocketProcessor(socket));
        java.util.logging.Logger.getGlobal().info("SocketProcessor added");
    }
}
