package main;

import accounts.AccountService;
import chat.WebSocketChatServlet;
import dbService.DBServiceImpl;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

/**
 * Created by clr on 14.11.2016.
 */
public class Main {
    public static void main (String[] args) throws Exception {

        DBServiceImpl dbServiceImpl = new DBServiceImpl();
        AccountService accountService = new AccountService(dbServiceImpl);
        dbServiceImpl.printConnectInfo();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        context.addServlet(new ServletHolder(new WebSocketChatServlet()), "/chat");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("public_html");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[] {resourceHandler, context});

        Server server = new Server(8080);
        server.setHandler(handlerList);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
