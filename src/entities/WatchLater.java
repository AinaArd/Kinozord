package entities;

public class WatchLater {
    private long id;
    private String userPostponer;
    private String postponedFilm;

    public WatchLater(long id, String userPostponer, String postponedFilm) {
        this(id, postponedFilm);
        this.userPostponer = userPostponer;
    }

    public WatchLater(long id, String postponedFilm) {
        this.id = id;
        this.postponedFilm = postponedFilm;
    }

    public String getUserPostponer() {
        return userPostponer;
    }

    public void setUserPostponer(String userPostponer) {
        this.userPostponer = userPostponer;
    }

    public String getPostponedFilm() {
        return postponedFilm;
    }

    public void setPostponedFilm(String postponedFilm) {
        this.postponedFilm = postponedFilm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
