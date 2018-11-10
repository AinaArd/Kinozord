package DAO;

import entities.*;
import helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public static List<Liked> getLikedFilms(User user) {
        try {
            PreparedStatement ps = Helper.getConnection().prepareStatement("select * from liked where user_who_liked=?");
            ps.setLong(1,user.getId());
            ResultSet rs = ps.executeQuery();
            List<Liked> liked = new ArrayList<>();
            while(rs.next()) {
                liked.add(new Liked(rs.getLong("id"),rs.getString("user_who_liked"),
                        rs.getString("liked_film"), rs.getInt("rate")));
            }
            return liked;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Liked> getNamesOfLiked(User user){
        try {
            PreparedStatement ps = Helper.getConnection().prepareStatement("select liked.id, f.name from liked" +
                    " inner join film f on liked.liked_film = f.id where user_who_liked=?");
            ps.setLong(1,user.getId());
            ResultSet rs = ps.executeQuery();
            List<Liked> likeds = new ArrayList<>();
            while(rs.next()) {
                likeds.add(new Liked(rs.getLong("id"), rs.getString("name")));
            }
            return likeds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Neutral> getNamesOfNeutral(User user) {
        try {
            PreparedStatement ps = Helper.getConnection().prepareStatement("select neutral.id,f.name from neutral " +
                    "inner join film f on neutral.neutral_film = f.id where user_neutral=?");
            ps.setLong(1,user.getId());
            ResultSet rs = ps.executeQuery();
            List<Neutral> neutrals = new ArrayList<>();
            while(rs.next()) {
                //TODO: надо сделать join с user чтобы имя user выводить(?)
                neutrals.add(new Neutral(rs.getLong("id"), rs.getString("name")));
            }
            return neutrals;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Disliked> getNamesOfDisliked(User user) {
        try {
            PreparedStatement ps = Helper.getConnection().prepareStatement("select disliked.id,f.name from disliked " +
                    "inner join film f on disliked.disliked_film = f.id where user_who_disliked=?");
            ps.setLong(1,user.getId());
            ResultSet rs = ps.executeQuery();
            List<Disliked> dislikeds = new ArrayList<>();
            while(rs.next()) {
                dislikeds.add(new Disliked(rs.getLong("id"), rs.getString("name")));
            }
            return dislikeds;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<WatchLater> getNamesOfWatchLater(User user) {
        try {
            PreparedStatement ps = Helper.getConnection().prepareStatement("select watch_later.id, f.name from watch_later " +
                    "inner join film f on watch_later.postponed_film = f.id where user_who_postponed=?");
            ps.setLong(1,user.getId());
            ResultSet rs = ps.executeQuery();
            List<WatchLater> watchLaters = new ArrayList<>();
            while(rs.next()) {
                watchLaters.add(new WatchLater(rs.getLong("id"), rs.getString("name")));
            }
            return watchLaters;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
