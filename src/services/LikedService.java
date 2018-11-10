package services;

import DAO.CategoryDAO;
import entities.Liked;
import entities.User;

import java.util.List;

public class LikedService {

    public List<Liked> getLikedFilms(User user) {
        return CategoryDAO.getLikedFilms(user);
    }
}
