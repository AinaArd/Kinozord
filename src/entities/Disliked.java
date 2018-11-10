package entities;

public class Disliked {
    private long id;
    private String whoDisLikes;
    private String dislikedFilm;

    public Disliked(long id, String whoDisLikes, String dislikedFilm) {
        this(id, dislikedFilm);
        this.whoDisLikes = whoDisLikes;
    }

    public Disliked(long id, String dislikedFilm) {
        this.id = id;
        this.dislikedFilm = dislikedFilm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWhoDisLikes() {
        return whoDisLikes;
    }

    public void setWhoDisLikes(String whoDisLikes) {
        this.whoDisLikes = whoDisLikes;
    }

    public String getDislikedFilm() {
        return dislikedFilm;
    }

    public void setDislikedFilm(String dislikedFilm) {
        this.dislikedFilm = dislikedFilm;
    }

    @Override
    public String toString() {
        return "Disliked{" +
                "id=" + id +
                ", whoDisLikes='" + whoDisLikes + '\'' +
                ", dislikedFilm='" + dislikedFilm + '\'' +
                '}';
    }
}
