package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by clr on 28.12.2016.
 */
public class SocketProcessor implements Runnable {
    private final Socket socket;

    public SocketProcessor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
            java.util.logging.Logger.getGlobal().info("Processing socket");
            while (true) {
                String inputLine = in.readLine();
                if (inputLine.equals("Bye")) {
                    System.out.println(inputLine);
                    break;
                } else out.println(inputLine);
            }
            socket.close();
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
