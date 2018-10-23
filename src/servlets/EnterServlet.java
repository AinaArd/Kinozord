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
//        request.getRequestDispatcher("enterpage.jsp").forward(request,response);
      /*  response.getWriter().print("<html>\n" +
                "<head>\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/style.css\">\t<title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t\t<h1>Continue as</h1>\n" +
                "\t<span id=\"b1\">\n" +
                "\t\t<a href='#' id='bb2'>Guest</a>\n" +
                "\t</span>\t\t\t\t\n" +
                "\t<span id=\"b2\">\n" +
                "\t\t<a href='#' onclick=\"show('block')\" id='bb1'>Authorised User</a>\n" +
                "\t</span>\n" +
                "\t\t<div onclick=\"show('none')\" id=\"gray\"></div>\n" +
                "\t\t<div id=\"window\">\n" +
                "\t\t\t<div class=\"form\">\n" +
                "                <div style=\"margin-top: 20%; margin-left: -150%;\" ><a href='register.html' id=\"bb1\">New User</a></div>\n" +
                "                <div style=\"margin-top: 40%;margin-left: -150%;\"><a href='LogIn.html' id=\"bb1\">Log In</a></div>\n" +
                "\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<script>\n" +
                "            //Функция показа\n" +
                "            function show(state)\n" +
                "            {\n" +
                "                document.getElementById('window').style.display = state;\n" +
                "                document.getElementById('gray').style.display = state;\n" +
                "            }\n" +
                "\t\t</script>\n" +
                "</body>\n" +
                "</html>");*/

            }
        }
    }
}
