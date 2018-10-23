package entities;

public class Neutral {
    private User neutralUser;
    private Film neutralFilm;

    public Neutral(User neutralUser, Film neutralFilm) {
        this.neutralUser = neutralUser;
        this.neutralFilm = neutralFilm;
    }

    public User getNeutralUser() {
        return neutralUser;
    }

    public void setNeutralUser(User neutralUser) {
        this.neutralUser = neutralUser;
    }

    public Film getNeutralFilm() {
        return neutralFilm;
    }

    public void setNeutralFilm(Film neutralFilm) {
        this.neutralFilm = neutralFilm;
    }
}
