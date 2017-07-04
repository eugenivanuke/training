package services.socketListener;

import messageSystem.MessageSystem;
import messageSystem.msg.Abonent;
import messageSystem.msg.Address;
import messageSystem.msg.msgToTaskExecutor.MsgExecute;
import services.taskExecutor.TaskExecutor;
import tasks.SocketRW;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by clr on 11.12.2016.
 */
public class SocketListener implements Runnable, Abonent {
    private Address address;
    private final TaskExecutor taskExecutor;
    private final MessageSystem messageSystem;

    public SocketListener (MessageSystem messageSystem, TaskExecutor taskExecutor) {
        this.messageSystem = messageSystem;
        this.taskExecutor = taskExecutor;
        this.address = new Address();
        
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public void run() {

        try {
            int PORT = 5050;
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            Selector selector = Selector.open();
            serverSocketChannel.configureBlocking(false);

            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server on port: " + PORT);
            while (true) {
                selector.select();
                Iterator it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey selectionKey = (SelectionKey) it.next();
                    it.remove();
                    if (selectionKey.isAcceptable()) {
                        SocketChannel channel = serverSocketChannel.accept();
                        System.out.println("Accepted connection from:"
                                + channel.socket());
                        channel.configureBlocking(false);
                        this.messageSystem.sendMessage(new MsgExecute
                                (this.address, taskExecutor.getAddress(), channel));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
