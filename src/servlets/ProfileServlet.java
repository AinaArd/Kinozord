package servlets;

import DAO.CategoryDAO;
import DAO.PostsDAO;
import entities.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import helper.Helper;
import services.PostService;

import javax.jms.Session;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProfileServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getParameter("realName");
        String login = Helper.getUserService().getCurrentUser(request).getLogin();

        String newName = request.getParameter("newName");
        String newLogin = request.getParameter("newLogin");
        String newPassword = request.getParameter("newPassword");
        Helper.getUserService().updateUser(login, newName, newLogin, newPassword);

        response.sendRedirect("/profile");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        Helper.remembered(request, response, request.getSession());
        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("current_user");

        if (loggedUser != null) {
            Configuration cfg = ConfigSingleton.getConfig(getServletContext());
            Template tmpl = cfg.getTemplate("profile.ftl");
            HashMap<String, Object> root = new HashMap<>();
            root.put("user", loggedUser);

            List<Post> posts = PostsDAO.getUserPosts(loggedUser);
            root.put("posts", posts);

            List<Liked> likeds = CategoryDAO.getNamesOfLiked(loggedUser);
            root.put("liked", likeds);

            List<Neutral> neutrals = CategoryDAO.getNamesOfNeutral(loggedUser);
            root.put("neutral", neutrals);

            List<Disliked> dislikeds = CategoryDAO.getNamesOfDisliked(loggedUser);
            root.put("disliked", dislikeds);

            List<WatchLater> watchLaters = CategoryDAO.getNamesOfWatchLater(loggedUser);
            root.put("later", watchLaters);

            try {
                tmpl.process(root, response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login");
        }

       /* try {
            PreparedStatement st = (PreparedStatement) Helper.getConnection().prepareStatement("select name from 'user' where login = ?");
            ResultSet rs = st.executeQuery();
            rs.next();

            HashMap<String, Object> root = new HashMap<>();
            root.put("form_url", request.getRequestURI());
            ArrayList<User> users = new ArrayList<>();

            while (rs.next()) {
                users.add(new User(rs.getString("login"), rs.getString("name"), rs.getString("nickname"),
                        rs.getInt("age")));
            }
            root.put("users", users);

            PostService postService = Helper.getPostService();
            List<Post> userPosts = postService.getUserPosts(Helper.getUserService().getCurrentUser(request));

            Template tmpl = cfg.getTemplate("profile.ftl");
            HashMap<String, Object> rootSec = new HashMap<>();
            rootSec.put("form_url", request.getRequestURI());
            try {
                tmpl.process(rootSec, response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
