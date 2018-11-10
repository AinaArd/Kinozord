package DAO;

import entities.Post;
import entities.User;
import helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostsDAO {

   /* public static List<Post> getPostsFromDB(User user) {
        List<Post> posts = new ArrayList<>();
        Post p = getUserPost(user);
        while (p != null) {
            posts.add(p);

            p = getUserPost(user);
        }
        return posts;
    }*/

    public static List<Post> getUserPosts(User user) {
        try {
            PreparedStatement pr = Helper.getConnection().prepareStatement("select * from \"post\" where user_publisher=? ");
            pr.setLong(1, user.getId());
            ResultSet rs = pr.executeQuery();
            List<Post> posts = new ArrayList<>();
            while (rs.next()) {
                posts.add(new Post(rs.getLong("id"), rs.getString("context"), rs.getLong("user_publisher"),
                        rs.getString("date")));
            }
            return posts;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
