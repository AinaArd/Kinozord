package DAO;

import entities.User;
import helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleUserDAO {

    public static User getUserByLogin(String login) {
        try {
            PreparedStatement pr = Helper.getConnection().prepareStatement("select * from \"user\" where login=? ");
            pr.setString(1, login);
            ResultSet rs = pr.executeQuery();

            if (!rs.next()) {
                return null;
            } else {
                return new User(rs.getLong("id"), rs.getString("login"), rs.getString("password"),
                        rs.getString("name"), rs.getString("picture"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean checkPass(User u, String password) {
        return u.getPassword().equals(password);
    }

    public void registerNewUser(String userName, String userLogin, String userPassword, String filePath) {
        try {
            PreparedStatement pr = Helper.getConnection().prepareStatement("insert into \"user\" (\"name\",\"login\",\"password\", \"picture\") " +
                    "values (?, ?, ?, ?);");
            pr.setString(1, userName);
            pr.setString(2, userLogin);
            pr.setString(3, userPassword);
            pr.setString(4, filePath);
            pr.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User updateUserInDB(User user, String newName, String newLogin, String newPassword) {
        try {
//            newPassword = Helper.encripting(newPassword);
            PreparedStatement st = Helper.getConnection().prepareStatement("update \"user\" set name=?, login=?, password=? where login=?");
            st.setString(1, newName);
            st.setString(2, newLogin);
            st.setString(3, newPassword);
            st.setString(4, user.getLogin());
            st.executeUpdate();
            return getUserByLogin(newLogin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User findFilm(String name) {
        try {
            PreparedStatement ps = Helper.getConnection().prepareStatement("select * from \"user\" where name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            } else {
                return new User(rs.getLong("id"), rs.getString("login"), rs.getString("password"),
                        rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


   /* public List<Post> getUserPosts(User user) {
        if (posts == null) {
            posts = new ArrayList<>();
        } else {
            for (Post post : posts) {
                if (post.getUserPublisher() == user.getName()) {
                    posts.add(post);
                }
            }
        }
        return posts;
    }
*/
    /*@Override
    public User getUserById(int id) {
        List<User> users = DataBase.getUsers();
        for (User user : users) {
            *//*if (user.getId() = id) {
                return user;
            }*//*
        }
        return null;
    }*/
}