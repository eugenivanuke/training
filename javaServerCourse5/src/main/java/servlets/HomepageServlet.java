package servlets;

import accountServer.AccountServerI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by clr on 23.11.2016.
 */
public class HomepageServlet extends HttpServlet {
    private final AccountServerI accountServer;
    public static final String PAGE_URL = "/admin";
    static final Logger logger = LogManager.getLogger(HomepageServlet.class.getName());

    public HomepageServlet(AccountServerI accountServer) {
        this.accountServer = accountServer;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        logger.info("Got get");

        res.setContentType("text/html;charset=utf-8");
        res.setStatus(HttpServletResponse.SC_OK);
        res.getWriter().println(accountServer.getUsersLimit());
    }
}
