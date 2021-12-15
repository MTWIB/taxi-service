package mate.controller;

import java.io.IOException;
import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mate.lib.Injector;
import mate.model.Driver;
import mate.service.AuthenticationService;

public class LoginController extends HttpServlet {
    private static final String SESSION_ATTRIBUTE_ID = "driver_id";
    private static final Injector injector = Injector.getInstance("mate");
    private static final AuthenticationService authenticationService = (AuthenticationService)
            injector.getInstance(AuthenticationService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/drivers/login.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        try {
            Driver driver = authenticationService.login(req.getParameter("login"),
                    req.getParameter("password"));
            HttpSession session = req.getSession();
            session.setAttribute(SESSION_ATTRIBUTE_ID, driver.getId());
            resp.sendRedirect("/index");
        } catch (AuthenticationException e) {
            req.setAttribute("errorMsg", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/drivers/login.jsp").forward(req, resp);
        }
    }
}
