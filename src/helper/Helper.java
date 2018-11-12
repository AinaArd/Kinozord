package helper;

import entities.Liked;
import services.PostService;
import services.UserService;

import javax.servlet.http.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    private static Connection conn = null;
    private static UserService userService = null;
    private static PostService postService = null;

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

   /* public static boolean validation(String name, String pass) {
        Pattern patternName = Pattern.compile("[/^[a-z]+$/]");
        Matcher m1 = patternName.matcher(name);
        Pattern patternPass = Pattern.compile("[/^[a-z]+$/]");
        Matcher m = patternPass.matcher(pass);
        if (m.matches() && m1.matches()) {
            return true;
        }
        return false;
    }*/

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
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public static PostService getPostService() {
        if (userService == null) {
            userService = new UserService();
        }
        return postService;
    }

  /*  private static Post makeORMPost(ResultSet resultSet) {
        try {
            resultSet.next();
            return new Post(resultSet.getString("context"), resultSet.getString("user_publisher"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Post> makeORMPosts(ResultSet resultSet) {
        List<Post> posts = new ArrayList<>();
        Post p = makeORMPost(resultSet);
        while (p != null) {
            posts.add(p);
            p = makeORMPost(resultSet);
        }
        return posts;
    }*/

    private static Liked makeORMLiked(ResultSet rs) {
        try {
            rs.next();
//            return new Liked(rs.getString("user_who_liked"), "liked_film");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Liked> makeORMLikedList(ResultSet rs) {
        List<Liked> liked = new ArrayList<>();
        Liked l = makeORMLiked(rs);
        while (l != null) {
            liked.add(l);
            l = makeORMLiked(rs);
        }
        return liked;
    }

    public static String getFileName(final Part part) {
        System.out.println(part.getHeader("content-disposition"));
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    public static boolean validation(String name, String login, String password) {
        // первый символ - буква, 1-15 символов, буквы и цифры
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,15}$");
        // 1-20 символов, буквы, цифры, дефисы и подчёркивания
        Pattern pattern1 = Pattern.compile("/^[a-z0-9_-]{1,20}$/");
        // строчные и прописные буквы и цифры
        Pattern pattern2 = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");

        Matcher matcher = pattern.matcher(name);
        Matcher matcher1 = pattern1.matcher(login);
        Matcher matcher2 = pattern2.matcher(password);

        return matcher.matches() && matcher1.matches() && matcher2.matches();
    }

    /*private static Disliked makeORMDisliked(ResultSet rs) {
        try {
            rs.next();
            return new Disliked(rs.getString("user_who_disliked"), "disliked_film");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

   /* public static List<Disliked> makeORMDislikedList(ResultSet rs) {
        List<Disliked> disliked = new ArrayList<>();
        Disliked d = makeORMDisliked(rs);
        while (d != null) {
            disliked.add(d);
            d = makeORMDisliked(rs);
        }
        return disliked;
    }*/

    /*private static Neutral makeORMNeutral(ResultSet rs) {
        try {
            rs.next();
            return new Neutral(rs.getString("user_neutral"), "neutral_film");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Neutral> makeORMNeutralList(ResultSet rs) {
        List<Neutral> neutral = new ArrayList<>();
        Neutral n = makeORMNeutral(rs);
        while(n != null) {
            neutral.add(n);
            n = makeORMNeutral(rs);
        }
        return neutral;
    }*/

}
