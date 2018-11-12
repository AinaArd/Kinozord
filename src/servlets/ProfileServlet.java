package servlets;

import DAO.CategoryDAO;
import DAO.PostsDAO;
import DAO.SimpleUserDAO;
import entities.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import helper.Helper;
import services.CategoryService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProfileServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getParameter("realName");
        HttpSession session = request.getSession();
        User current_user = (User) session.getAttribute("current_user");

        String newName = request.getParameter("newName");
        String newLogin = request.getParameter("newLogin");
        String newPassword = request.getParameter("newPassword");
        User newUser = SimpleUserDAO.updateUserInDB(current_user, newName, newLogin, newPassword);
        session.setAttribute("сurrent_user", newUser);


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

            List<Liked> likeds = CategoryService.getLikedFilms(loggedUser);
            root.put("liked", likeds);

            List<Neutral> neutrals = CategoryService.getNeutralFilms(loggedUser);
            root.put("neutral", neutrals);

            List<Disliked> dislikeds = CategoryService.getDislikedFilms(loggedUser);
            root.put("disliked", dislikeds);

            List<WatchLater> watchLaters = CategoryService.getWatchLaterFilms(loggedUser);
            root.put("later", watchLaters);

            List<Subscription> subscribers = CategoryService.getSubscribers(loggedUser);
            root.put("subscribers", subscribers);

            try {
                tmpl.process(root, response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login");
        }
    }
}
