package DAO;

import data.DataBase;
import entities.User;

import java.util.List;

public class SimpleUserDAO implements UserDAO {
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