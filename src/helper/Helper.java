package helper;

import DAO.SimpleUserDAO;
import services.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    private static Connection conn = null;
    private static UserService userService = null;

    public static boolean remembered(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        boolean cookiesExists = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(request.getParameter("login"))) {
                    session.setAttribute("current_user", request.getParameter("login"));
                    cookiesExists = true;
                    try {
                        response.sendRedirect("/profile");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return cookiesExists;
    }

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/post", "postgres", "postgres");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static boolean validation(String name, String pass) {
        Pattern patternName = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_.]{1,20}$");
        Matcher m1 = patternName.matcher(name);
        Pattern patternPass = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
        Matcher m = patternPass.matcher(pass);
        if (m.matches() && m1.matches()) {
            return true;
        }
        return false;
    }

    public static String encripting(String password) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }
        return md5Hex;
    }

    public static UserService getUserService() {
        if(userService == null){
            userService= new UserService();
        }
        return userService;
    }
}