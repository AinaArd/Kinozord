package servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import helper.Helper;

import javax.jms.Session;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ProfileServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // TODO: едит профиля и редирект на едит
        request.getParameter("realName");
        String login = Helper.getUserService().getCurrentUser(request).getLogin();

        response.sendRedirect("/edit");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        Session session = (Session) request.getSession();
        Configuration cfg = ConfigSingleton.getConfig(getServletContext());
        // TODO: waiting for profile.html
        String login = Helper.getUserService().getCurrentUser(request).getLogin();
        try {
            PreparedStatement st = (PreparedStatement) Helper.getConnection().prepareStatement("select name from 'user' where login = ?");
            ResultSet rs = st.executeQuery();
            rs.next();

            String realName = rs.getString("name");

            Template tmpl = cfg.getTemplate("profile.ftl");
            HashMap<String, Object> root = new HashMap<>();
            root.put("form_url", request.getRequestURI());
            try {
                tmpl.process(root, response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
