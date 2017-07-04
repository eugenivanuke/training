package resourceServlet;

import resourceServer.ResourceServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by clr on 06.12.2016.
 */
public class ResourceServlet extends HttpServlet {
    private final ResourceServer resourceServer;

    public ResourceServlet (ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("Well, at least something works");
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String path = request.getParameter("path");

        if (path == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Loser!");
        }

        resourceServer.saveParsedFrom(path);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("Well, look at jconsole.");
    }
}
