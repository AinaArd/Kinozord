package servlets;

import DAO.SimpleUserDAO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import helper.Helper;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

public class RegistrationServlet extends HttpServlet {
    private UserService userService = Helper.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String user = (String) session.getAttribute("current_user");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("password");
        if (user != null) {
            response.sendRedirect("/profile");
        } else {
            if (Helper.validation(login, password)) {
                //TODO register user in DB
                userService.registerNewUser(name, login, password);
                session.setAttribute("login", login);
                Cookie cookie = new Cookie(login, password);
                cookie.setMaxAge(24 * 60 * 60);
                response.addCookie(cookie);
                response.sendRedirect("/login");
            } else {
                response.sendRedirect("/login");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("current_user");
        if (user != null) {
            response.sendRedirect("/profile");
        } else {
            if (!Helper.remembered(request, response, session)) {
                Configuration cfg = ConfigSingleton.getConfig(getServletContext());
                Template tmpl = cfg.getTemplate("register.html");
                HashMap<String, Object> root = new HashMap<>();
                root.put("form_url", request.getRequestURI());
                try {
                    tmpl.process(root, response.getWriter());
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
