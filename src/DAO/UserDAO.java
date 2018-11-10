package DAO;

import entities.User;

public interface UserDAO {
    User getUserByLogin(String login);
}
