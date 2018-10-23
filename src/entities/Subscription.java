package entities;

public class Subscription {
    private User userTarget;
    private User userSubscriber;

    public Subscription(User userTarget, User userSubscriber) {
        this.userTarget = userTarget;
        this.userSubscriber = userSubscriber;
    }

    public User getUserTarget() {
        return userTarget;
    }

    public void setUserTarget(User userTarget) {
        this.userTarget = userTarget;
    }

    public User getUserSubscriber() {
        return userSubscriber;
    }

    public void setUserSubscriber(User userSubscriber) {
        this.userSubscriber = userSubscriber;
    }
}
