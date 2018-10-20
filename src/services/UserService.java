package services;
import DAO.SimpleUserDAO;
import DAO.UserDAO;
import entities.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;

import DAO.UserDAO;

public class UserService {
    private UserDAO userDAO = new SimpleUserDAO();

    public User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current_user");
        return user;
    }

    public User authenticate(HttpServletRequest request) {
        String userLogin = request.getParameter("login");
        String userPass = request.getParameter("password");
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/post\",\n" +
                    "                    \"postgres\",\n" +
                    "                    \"postgres\"");
            PreparedStatement st = conn.prepareStatement("select * from 'user' where name =" + userLogin + ", password = " + userPass);
            ResultSet rs = st.executeQuery();
            rs.next();
            if (!rs.next()) {
                return null;
            } else {
                return userDAO.getUserByName(userLogin);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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
    }

    public void authorize(User current_user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("current_user", current_user);
    }
}