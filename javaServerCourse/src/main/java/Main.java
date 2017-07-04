import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.logging.Logger;

/**
 * Created by clr on 18.10.2016.
 */
public class Main {
    public static void main (String[] args) throws Exception {
        Server server = new Server(8080);

        MirrorServlet mirrorServlet = new MirrorServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(mirrorServlet), "/mirror");

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();

    }
}
