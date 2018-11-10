package entities;

public class Subscription {
    private long id;
    private String userTarget;
    private String userSubscriber;

    public Subscription(long id, String userTarget, String userSubscriber) {
        this(id,userSubscriber);
        this.userTarget = userTarget;
    }

    public Subscription(long id, String userSubscriber) {
        this.id = id;
        this.userSubscriber = userSubscriber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserTarget() {
        return userTarget;
    }

    public void setUserTarget(String userTarget) {
        this.userTarget = userTarget;
    }

    public String getUserSubscriber() {
        return userSubscriber;
    }

    public void setUserSubscriber(String userSubscriber) {
        this.userSubscriber = userSubscriber;
    }
}
