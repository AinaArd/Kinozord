package DAO;

import entities.User;

public interface UserDAO {
    User getUserByName(String username);
}
