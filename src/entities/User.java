package entities;

public class User {
    private long id;
    private String name;
    private String login;
    private String nickname;
    private int age;
    private String password;

    public User(String login, String name, String nickname, int age) {
        this.login = login;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }

    public User(long id, String login, String password, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public User(long id, String name, String login, String nickname, int age, String password) {
        this(id, name, login, password);
        this.nickname = nickname;
        this.age = age;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
