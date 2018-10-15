package entities;

public class Post {
    private String text;
    private User userPublisher;

    public Post(String text, User userPublisher) {
        this.text = text;
        this.userPublisher = userPublisher;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUserPublisher() {
        return userPublisher;
    }

    public void setUserPublisher(User userPublisher) {
        this.userPublisher = userPublisher;
    }
}
