import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by clr on 18.10.2016.
 */
public class MirrorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.getWriter().println(request.getParameter("key"));

        response.setContentType("text/http;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
