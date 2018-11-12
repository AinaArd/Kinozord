package services;

import DAO.SimpleUserDAO;
import entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    public User userSearch(String name) {
        return SimpleUserDAO.findFilm(name);
    }

    public void authorize(User current_user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("current_user", current_user);
    }

    public void registerNewUser(String name, String login, String password, String filePath) {
        password = Helper.encripting(password);
        userDAO.registerNewUser(name, login, password, filePath);
    }

    public User updateUser(User oldUser, String newName, String newLogin, String newPassword) {
        return SimpleUserDAO.updateUserInDB(oldUser, newName, newLogin, newPassword);
    }
}