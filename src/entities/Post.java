package entities;

public class Post {
    private String text;
    private String userPublisher;

    public Post(String text, String userPublisher) {
        this.text = text;
        this.userPublisher = userPublisher;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserPublisher() {
        return userPublisher;
    }

    public void setUserPublisher(String userPublisher) {
        this.userPublisher = userPublisher;
    }
}
