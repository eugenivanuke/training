package messageSystem;

import executor.Executor;
import messageSystem.msg.Message;
import messageSystem.msg.messageToExecutor.MsgServe;
import org.junit.After;
import org.junit.Test;
import tasks.SocketListener;

import java.net.Socket;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MessageSystemTest {
    private MessageSystem messageSystem = new MessageSystem();
    private Executor executor = new Executor(messageSystem);
    private SocketListener socketListener = mock(SocketListener.class);

    @Test
    public void testMessage(){
        Socket messageSocket = new Socket();
        messageSystem.addSubscriber(executor);
        Message message = new MsgServe(new Address(), executor.getAddress(), messageSocket);
        messageSystem.sendMessage(message);

        assertFalse(messageSystem.getMessages().isEmpty());
    }

    @Test
    public void testSendMessage(){
        when(socketListener.getAddress()).thenReturn(new Address());
        messageSystem.addSubscriber(executor);
        Thread executorThread = new Thread(executor);
        Socket socket = new Socket();

        executorThread.setName("Executor");
        executorThread.start();

        messageSystem.sendMessage(new MsgServe(socketListener.getAddress(), executor.getAddress(), socket));
        assertFalse(messageSystem.getMessages().isEmpty());
    }

}