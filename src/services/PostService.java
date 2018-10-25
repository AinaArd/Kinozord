package services;

import DAO.PostsDAO;
import entities.Post;
import entities.User;

import java.util.List;

public class PostService {
    PostsDAO postsDAO = new PostsDAO();
    public  List<Post> getUserPosts(User user) {
        return PostsDAO.getPostsFromDB();
    }
}
