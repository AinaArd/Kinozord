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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        // TODO: check parameters, как выводить эти фильмы

        String nameOfFilm = request.getParameter("name");
        String country = request.getParameter("country");
        String year = request.getParameter("year");
        String rate = request.getParameter("rate");

        session.setAttribute("nameOfFilm", nameOfFilm);
        session.setAttribute("country", country);
        session.setAttribute("year", year);
        session.setAttribute("rate", rate);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        Configuration cfg = ConfigSingleton.getConfig(getServletContext());
        Template tmpl = cfg.getTemplate("search.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("form_url", request.getRequestURI());

        String nameOfFilm = "name";
        String country = "country";
        String year = "year";
        String rate = "rate";


        if ((nameOfFilm.equals("name")) || (country.equals("country")) || (year.equals("year")) || (rate.equals("rate"))) {
            nameOfFilm = (String) session.getAttribute("nameOfFilm");
            country = (String) session.getAttribute("country");
            year = (String) session.getAttribute("year");
            rate = (String) session.getAttribute("rate");

            List<Film> foundFilms = FilmDAO.findFilms(nameOfFilm, country, year, rate);
            root.put("films", foundFilms);


            try {
                tmpl.process(root, response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
    }
}
