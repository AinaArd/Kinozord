package servlets;

import DAO.FilmDAO;
import DAO.SimpleUserDAO;
import entities.Film;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static DAO.FilmDAO.findFilm;

public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // TODO: check parameters, как выводить эти фильмы

        String nameOfFilm = request.getParameter("name");
        String country = request.getParameter("country");
        int year = Integer.parseInt(request.getParameter("year"));
        int rate = Integer.parseInt(request.getParameter("rate"));

        List<Film> foundFilms = FilmDAO.findFilm(nameOfFilm,country,year,rate);
        System.out.println(Arrays.asList(foundFilms));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Configuration cfg = ConfigSingleton.getConfig(getServletContext());
        Template tmpl = cfg.getTemplate("search.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("form_url", request.getRequestURI());
        try {
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
