package servlets;

import accounts.AccountService;
import accounts.UserProfiles;
import dbService.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by clr on 06.11.2016.
 */
public class SignInServlet extends HttpServlet {
    AccountService accountService;

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

        UserProfiles userProfiles = null;
        try {
            userProfiles = accountService.getByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        if (userProfiles == null || !userProfiles.getPassword().equals(password)) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(401);
            response.getWriter().println("Unauthorized");
        }

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(200);
        response.getWriter().println("Authorized " + login);
    }
}
