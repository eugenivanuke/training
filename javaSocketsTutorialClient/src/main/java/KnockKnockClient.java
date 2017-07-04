import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KnockKnockClient {
    private static ExecutorService threadPool = Executors.newCachedThreadPool();
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println(
                    "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        for (int i = 0; i < 10; i++) {
            threadPool.submit(new Spammer(hostName, portNumber, i));
        }

        threadPool.shutdown();
    }
}