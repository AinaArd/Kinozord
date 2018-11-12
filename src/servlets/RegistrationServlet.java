package servlets;

import entities.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import helper.Helper;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;

@MultipartConfig
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

//            if (Helper.validation(name, login, password)) {

                String path = "C:\\Programming\\Kinozord\\web\\avatars\\";
                Part filePart = request.getPart("file");
                String fileName = Helper.getFileName(filePart);

                OutputStream out = null;
                InputStream filecontent = null;
                final PrintWriter writer = response.getWriter();

                try {
                    out = new FileOutputStream(new File(path + File.separator + fileName));
                    filecontent = filePart.getInputStream();

                    int read = 0;
                    final byte[] bytes = new byte[512];

                    while ((read = filecontent.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                } catch (FileNotFoundException fne) {
                } finally {
                    if (out != null) {
                        out.close();
                    }
                    if (filecontent != null) {
                        filecontent.close();
                    }
                    if (writer != null) {
                        writer.close();
                    }
                }

                userService.registerNewUser(name, login, password, path + fileName);
                session.setAttribute("current_user", currentUser);
                response.sendRedirect("/login");
            }
        }
//    }


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
