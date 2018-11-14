package servlets;

import data.DataBase;
import entities.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import helper.Helper;
import services.UserService;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.swing.undo.CannotUndoException;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginServlet extends HttpServlet {
    private UserService userService = Helper.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");


        if (userService.getCurrentUser(request) != null) {
            response.sendRedirect("/profile");

        } else {
            String login = request.getParameter("login");
            String pass = request.getParameter("password");
//            pass = Helper.encripting(pass);

            if (request.getParameter("Remember") != null) {
                Cookie remembered = new Cookie(login, pass);
                remembered.setMaxAge(24 * 60 * 60);
                response.addCookie(remembered);
            }
            User current_user = userService.authenticate(login, pass);
            if (current_user != null) {
                userService.authorize(current_user, request);
                response.sendRedirect("/profile");
            } else
                response.sendRedirect("/login");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        if (userService.getCurrentUser(request) != null) {
            response.sendRedirect("/profile");
        } else if (!Helper.remembered(request, response, session)) {
            Configuration cfg = ConfigSingleton.getConfig(getServletContext());
            Template tmpl = cfg.getTemplate("LogIn.ftl");
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
