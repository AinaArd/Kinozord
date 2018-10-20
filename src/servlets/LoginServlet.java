package servlets;

import data.DataBase;
import entities.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        String name = request.getParameter("login");
        String pass = request.getParameter("password");

        if (userService.getCurrentUser(request) != null) {
            if (userExist(name, pass)) {
                if (request.getParameter("Remember") != null) {
                    Cookie remembered = new Cookie(name, pass);
                    remembered.setMaxAge(24 * 60 * 60);
                    response.addCookie(remembered);
                }
                Pattern patternName = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_.]{1,20}$");
                Matcher m1 = patternName.matcher(name);
                Pattern patternPass = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
                Matcher m = patternPass.matcher(pass);
                if (m.matches() && m1.matches()) {
                    session.setAttribute("current_user", name);
                    session.setAttribute("current_pass", pass);
                    response.sendRedirect("/profile");
                } else {
                    response.getWriter().print("<h1>Sorry," + "invalid data!" + "</h1>");
                }

            } else {
                response.sendRedirect("/login");
            }
            response.sendRedirect("/profile");
        } else {
            User current_user = userService.authenticate(request);
            if (current_user != null) {
                userService.authorize(current_user, request);
                response.sendRedirect("/profile");
            } else {
                response.sendRedirect("/login?err_mess=too_bad_login");
            }
        }

    }

    private boolean userExist(String name, String pass) {
        for(User user : DataBase.getUsers())
        if (user.getName().equals(name) && user.getPassword().equals(pass)) {
            return true;
        }
        return false;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        if (userService.getCurrentUser(request) != null) {
            response.sendRedirect("/profile");
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(request.getParameter("login"))) {
                    session.setAttribute("current_user", request.getParameter("login"));
                    response.sendRedirect("/profile");
                }
            }
            response.getWriter().print("<html lang=\"en\" >\n" +
                    "\n" +
                    "<head>\n" +
                    "  <meta charset=\"UTF-8\">\n" +
                    "  <title>Login Form</title>\n" +
                    "  <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/AuthStyle.css\">\n" +
                    "     \n" +
                    "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js\"></script>\n" +
                    "\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>\n" +
                    "\n" +
                    "  <div class=\"login\">\n" +
                    "\t<h1>Login</h1>\n" +
                    "    <form method=\"post\">\n" +
                    "    \t<input type=\"text\" name=\"u\" placeholder=\"Username\" required=\"required\" />\n" +
                    "        <input type=\"password\" name=\"p\" placeholder=\"Password\" required=\"required\" />\n" +
                    "        <button type=\"submit\" class=\"btn btn-primary btn-block btn-large\">Let me in.</button>\n" +
                    "    </form>\n" +
                    "</div>\n" +
                    "  \n" +
                    "  \n" +
                    "\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>\n");
        }

    }
}
