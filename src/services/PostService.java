package services;

import DAO.PostsDAO;
import entities.Post;
import entities.User;

import java.util.List;

public class PostService {

    public  List<Post> getUserPosts(User user) {
        return PostsDAO.getUserPosts(user);
    }
}
