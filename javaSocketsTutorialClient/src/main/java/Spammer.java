import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by clr on 04.01.2017.
 */
public class Spammer implements Runnable {
    private final String hostName;
    private final int portNumber;
    private final int mainId;
    
    public Spammer (String hostName, int portNumber, int mainId) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.mainId = mainId;
    }
    
    
    @Override
    public void run() {
        System.out.println("Run: " + mainId);
        try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            boolean stream = true;
            while (stream) {
                for (int i = 0; i < 5000; i++) {
                    out.println(i);
                }
                out.println("Bye");
                if(in.readLine() == "Bye") break;
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}
