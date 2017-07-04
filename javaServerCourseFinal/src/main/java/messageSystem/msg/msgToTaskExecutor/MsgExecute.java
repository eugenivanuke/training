package messageSystem.msg.msgToTaskExecutor;

import messageSystem.msg.Address;
import services.taskExecutor.TaskExecutor;
import tasks.SocketRW;

import java.nio.channels.SocketChannel;

/**
 * Created by clr on 21.12.2016.
 */
public class MsgExecute extends MsgToTE {
    private final SocketChannel socketChannel;

    public MsgExecute(Address from, Address to, SocketChannel socketChannel) {
        super(from, to);
        this.socketChannel = socketChannel;
    }

    @Override
    public void exec(TaskExecutor taskExecutor) {
        taskExecutor.execute(new SocketRW(socketChannel));
    }
}
