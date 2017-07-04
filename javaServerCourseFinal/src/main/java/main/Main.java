package main;


import messageSystem.MessageSystem;
import services.socketListener.SocketListener;
import services.taskExecutor.TaskExecutor;

public class Main {
    public static void main(String[] args) throws Exception {
        MessageSystem messageSystem = new MessageSystem();
        TaskExecutor taskExecutor = new TaskExecutor(messageSystem);
        SocketListener socketListener = new SocketListener(messageSystem, taskExecutor);

        new Thread(taskExecutor).start();
        new Thread(socketListener).start();
    }
}