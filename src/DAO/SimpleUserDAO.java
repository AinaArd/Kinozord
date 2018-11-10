package DAO;

import data.DataBase;
import entities.Post;
import entities.User;
import helper.Helper;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleUserDAO implements UserDAO {

    @Override
    public User getUserByLogin(String login) {
        try {
            PreparedStatement pr = Helper.getConnection().prepareStatement("select * from \"user\" where login=? ");
            pr.setString(1, login);
            ResultSet rs = pr.executeQuery();

            if (!rs.next()) {
                return null;
            } else {
             /*   User user = new User();
                user.setId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                return user;*/
                return new User(rs.getLong("id"),rs.getString("login"),rs.getString("password"),
                        rs.getString("name"));
               /* return new User(rs.getLong("id"),rs.getString("login"),
                        rs.getString("password"),rs.getString("name"));*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
       /* List<User> users = DataBase.getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;*/


    public boolean checkPass(User u, String password) {
        return u.getPassword().equals(password);
    }

    public void registerNewUser(String userName, String userLogin, String userPassword) {
        try {
            PreparedStatement pr = Helper.getConnection().prepareStatement("insert into \"user\" (\"name\",\"login\",\"password\") " +
                    "values (?, ?, ?);");
            pr.setString(1, userName);
            pr.setString(2, userLogin);
            pr.setString(3, userPassword);
            pr.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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