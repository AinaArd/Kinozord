package entities;

public class WatchLater {
    private User userPostponer;
    private Film postponedFilm;

    public WatchLater(User userPostponer, Film postponedFilm) {
        this.userPostponer = userPostponer;
        this.postponedFilm = postponedFilm;
    }

    public User getUserPostponer() {
        return userPostponer;
    }

    public void setUserPostponer(User userPostponer) {
        this.userPostponer = userPostponer;
    }

    public Film getPostponedFilm() {
        return postponedFilm;
    }

    public void setPostponedFilm(Film postponedFilm) {
        this.postponedFilm = postponedFilm;
    }
}
