package servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import helper.Helper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class EnterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("login");
        if (user != null) {
            response.sendRedirect("/profile");
        } else {
            if (!Helper.remembered(request, response, session)) {
                Configuration cfg = ConfigSingleton.getConfig(getServletContext());
                Template tmpl = cfg.getTemplate("welcome.html");
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
