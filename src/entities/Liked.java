package entities;

public class Liked {
    private User likes;
    private Film liked;

    public Liked(User likes, Film liked) {
        this.likes = likes;
        this.liked = liked;
    }

    public User getLikes() {
        return likes;
    }

    public void setLikes(User likes) {
        this.likes = likes;
    }

    public Film getLiked() {
        return liked;
    }

    public void setLiked(Film liked) {
        this.liked = liked;
    }
}
