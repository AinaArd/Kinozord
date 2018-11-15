package DAO;

import entities.Film;
import entities.User;
import helper.Helper;

import java.sql.*;
import java.util.ArrayList;
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
                foundFilms.add(new Film(rs.getLong("id"), rs.getInt("year"), rs.getString("country"),
                        rs.getInt("rate"), rs.getString("description"), rs.getString("name")));
            }
            return foundFilms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
