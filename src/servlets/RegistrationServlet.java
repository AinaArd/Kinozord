package servlets;

import DAO.SimpleUserDAO;
import entities.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import helper.Helper;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RegistrationServlet extends HttpServlet {
    private UserService userService = Helper.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        User currentUser = (User) session.getAttribute("current_user");

        if (currentUser != null) {
            response.sendRedirect("/profile");
        } else {
            String name = request.getParameter("name");
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            userService.registerNewUser(name, login, password);
            session.setAttribute("current_user", currentUser);
            response.sendRedirect("/login");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        User currentUser = userService.getCurrentUser(request);

        session.setAttribute("current_user", currentUser);

        if (currentUser != null) {
            response.sendRedirect("/profile");
        } else {
            if (!Helper.remembered(request, response, session)) {
                Configuration cfg = ConfigSingleton.getConfig(getServletContext());
                Template tmpl = cfg.getTemplate("register.ftl");
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
