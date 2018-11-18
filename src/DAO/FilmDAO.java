package DAO;

import entities.Category;
import entities.Film;
import entities.User;
import helper.Helper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmDAO {

    public static List<Film> getFilms() {
        try {
            Connection conn = Helper.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from film");
            ArrayList<Film> films = new ArrayList<>();
            while (rs.next()) {
                films.add(new Film(rs.getString("description"), rs.getString("name")));
            }
            return films;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Film> findFilms(String name, String country, String year, String rate) {
        try {
            PreparedStatement ps = Helper.getConnection().prepareStatement("select * from \"film\" where name =? or country=? or" +
                    " year=? or rate=?");
            ps.setString(1, name);
            ps.setString(2, country);
            ps.setString(3, year);
            ps.setString(4, rate);
            List<Film> foundFilms = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                foundFilms.add(new Film(rs.getLong("id"), rs.getString("description"), rs.getString("name"),
                        rs.getInt("year"), rs.getString("country"), rs.getInt("rate"), rs.getString("pic")));
            }
            return foundFilms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Film getFilmById(int id) {
        try {
            PreparedStatement ps = Helper.getConnection().prepareStatement("select * from category" +
                    " inner join film f on category.id = f.category where f.id =?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                return new Film(rs.getLong("id"), rs.getString("description"), rs.getString("name"),
                        rs.getInt("year"), rs.getString("country"), rs.getInt("rate"), rs.getString("pic"),
                        rs.getString("catname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
