package DAO;

import data.DataBase;
import entities.Post;
import entities.User;
import helper.Helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleUserDAO implements UserDAO {
    ArrayList<Post> posts = new ArrayList<>();

    @Override
    public User getUserByName(String username) {
        List<User> users = DataBase.getUsers();
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void registerNewUser(String name, String login, String password) {
        new User(name, login, password);
    }


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