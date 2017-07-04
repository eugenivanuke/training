package messageSystem.msg.messageToExecutor;

import executor.Executor;
import messageSystem.Address;
import messageSystem.Subscriber;
import messageSystem.msg.Message;
import tasks.SocketProcessor;

/**
 * Created by clr on 06.01.2017.
 */
public abstract class MsgToExecutor extends Message {
    public MsgToExecutor(Address fromWhom, Address whom) {
        super(fromWhom, whom);
    }

    public void exec(Subscriber subscriber){
        if(subscriber instanceof Executor){
            exec((Executor) subscriber);
        }
    }

    public abstract void exec(Executor executor);
}
