package entities;

public class Neutral {
    private long id;
    private String neutralUser;
    private String neutralFilm;

    public Neutral(long id, String neutralUser, String neutralFilm) {
        this(id, neutralFilm);
        this.neutralUser = neutralUser;
    }

    public Neutral(long id, String neutralFilm) {
        this.id = id;
        this.neutralFilm = neutralFilm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNeutralUser() {
        return neutralUser;
    }

    public void setNeutralUser(String neutralUser) {
        this.neutralUser = neutralUser;
    }

    public String getNeutralFilm() {
        return neutralFilm;
    }

    public void setNeutralFilm(String neutralFilm) {
        this.neutralFilm = neutralFilm;
    }

    @Override
    public String toString() {
        return "Neutral{" +
                "id=" + id +
                ", neutralUser='" + neutralUser + '\'' +
                ", neutralFilm='" + neutralFilm + '\'' +
                '}';
    }
}
