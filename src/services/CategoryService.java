package services;

import DAO.CategoryDAO;
import entities.*;

import java.util.List;

public class CategoryService {

    public static List<Liked> getLikedFilms(User user) {
        return CategoryDAO.getNamesOfLiked(user);
    }

    public static List<Neutral> getNeutralFilms(User user) {
        return CategoryDAO.getNamesOfNeutral(user);
    }

    public static List<Disliked> getDislikedFilms(User user) {
        return CategoryDAO.getNamesOfDisliked(user);
    }

    public static List<WatchLater> getWatchLaterFilms(User user) {
        return CategoryDAO.getNamesOfWatchLater(user);
    }

    public static List<Subscription> getSubscribers(User user) {
        return CategoryDAO.getNamesOfSubscribers(user);
    }
}
