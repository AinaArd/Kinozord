package services;

import DAO.SimpleUserDAO;
import entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.List;

import helper.Helper;

public class UserService {
    private SimpleUserDAO userDAO = new SimpleUserDAO();

    public User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current_user");
        return user;
    }

    public User authenticate(String login, String pass) {
        User u = userDAO.getUserByLogin(login);

        if (u != null) {
            if (userDAO.checkPass(u, pass)) {
                return u;
            } else
                return null;
        }
        return null;
    }

        /*if (username != null) {
            User user = userDAO.getByUsername(username);
            if (user == null) {
                return null;
            }
            String password = request.getParameter("password");
            if (password.equals(user.getPassword())) {
                return user;
            } else {
                return null;
            }
        }
        return null;
*/


        public void authorize (User current_user, HttpServletRequest request){
            HttpSession session = request.getSession();
            session.setAttribute("current_user", current_user);
        }

        public void registerNewUser (String name, String login, String password){
//        password = Helper.encripting(password);
            userDAO.registerNewUser(name, login, password);
        }

        public void updateUser (String oldLogin, String newName, String newLogin, String newPassword){
            try {
                PreparedStatement st = Helper.getConnection().prepareStatement("update user set name=" + newName + "login=" + newLogin +
                        "password=" + Helper.encripting(newPassword) +
                        "where login=" + oldLogin);
                st.setString(1, newName);
                st.setString(2, newLogin);
                st.setString(3, newPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }