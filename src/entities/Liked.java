package entities;

public class Liked {
    private long id;
    private String whoLikes;
    private String likedFilm;
    private int rate;

    public Liked(long id, String whoLikes, String likedFilm, int rate) {
        this(id,whoLikes,likedFilm);
        this.rate = rate;
    }

    public Liked(long id, String whoLikes, String likedFilm) {
        this.id = id;
        this.whoLikes = whoLikes;
        this.likedFilm = likedFilm;
    }

    public Liked(long id, String likedFilm) {
        this.id = id;
        this.likedFilm = likedFilm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWhoLikes() {
        return whoLikes;
    }

    public void setWhoLikes(String whoLikes) {
        this.whoLikes = whoLikes;
    }

    public String getLiked() {
        return likedFilm;
    }

    public void setLiked(String likedFilm) {
        this.likedFilm = likedFilm;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Liked{" +
                "id=" + id +
                ", whoLikes=" + whoLikes +
                ", likedFilm=" + likedFilm +
                ", rate=" + rate +
                '}';
    }
}
