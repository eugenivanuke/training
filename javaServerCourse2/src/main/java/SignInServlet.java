import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by clr on 28.10.2016.
 */
public class SignInServlet extends HttpServlet {
    private final AccountService accountService;

    public SignInServlet (AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost (HttpServletRequest request,
                        HttpServletResponse response)
                        throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        UserProfile userProfile = accountService.getUserByLogin(login);
        if (userProfile == null || !userProfile.getPassword().equals(password)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Unauthorized");
            response.setStatus(401);
            return;
        }

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(200);
        response.getWriter().println("Authorized " + login);


    }
}
