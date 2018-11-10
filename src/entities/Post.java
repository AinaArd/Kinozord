package entities;


import java.util.Date;

public class Post {
    private long id;
    private String text;
    private long userPublisher;
    private String dateOfPost;

    private Post(String text, long userPublisher) {
        this.text = text;
        this.userPublisher = userPublisher;
    }

    public Post() {

    }

    public Post(long id, String text, long user_publisher, String dateOfPost) {
        this(text, user_publisher);
        this.id = id;
        this.dateOfPost = dateOfPost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserPublisher() {
        return userPublisher;
    }

    public void setUserPublisher(long userPublisher) {
        this.userPublisher = userPublisher;
    }

    public String getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(String dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", userPublisher=" + userPublisher +
                ", dateOfPost=" + dateOfPost +
                '}';
    }
}
