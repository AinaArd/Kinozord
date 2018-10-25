package DAO;

import entities.Post;
import helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PostsDAO {
    public static List<Post> getPostsFromDB() {
        PreparedStatement st;
        try {
            st = (PreparedStatement) Helper.getConnection().createStatement();
            ResultSet rs = st.executeQuery();
            return Helper.makeORMPosts(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
