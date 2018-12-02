package servlets;

import DAO.FilmDAO;
import DAO.PostsDAO;
import DAO.SimpleUserDAO;
import entities.Film;
import entities.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import helper.Helper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.SimpleBeanInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class OneFilmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String receiverName = request.getParameter("receiver");
        String comment = request.getParameter("comment");

        User receiver = SimpleUserDAO.getUserByLogin(receiverName);
        System.out.println(receiver);

        if (PostsDAO.createNewPost(comment, receiverName)) {
            response.sendRedirect("/profile/" + receiver.getId());
        } else {
            response.sendRedirect("/films");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current_user");
        String s = request.getPathInfo().substring(1);
        int digit = Integer.parseInt(s);
        Film film = FilmDAO.getFilmById(digit);
        System.out.println(film);


        if (request.getParameter("watchlater") != null) {
            FilmDAO.addIntoWatchLater(user, film);
        } else if (request.getParameter("like") != null) {
            FilmDAO.addIntoLiked(user, film);
        } else if (request.getParameter("neutral") != null) {
            FilmDAO.addIntoNeutral(user, film);
        } else if (request.getParameter("dislike") != null) {
            FilmDAO.addIntoDisLiked(user, film);
        }

        Configuration cfg = ConfigSingleton.getConfig(getServletContext());
        Template tmpl = cfg.getTemplate("filmPage.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("form_url", request.getRequestURI());

        root.put("film", film);

        try {
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
