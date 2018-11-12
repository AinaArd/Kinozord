
package data;

public class DataBase {
    /*public static List<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/post", "postgres",
                    "postgres");
            PreparedStatement st = conn.prepareStatement("select * from user ");
            ResultSet rs = st.executeQuery();
            rs.next();
            while (rs.next()) {
                users.add(new User(rs.getString("name"), rs.getString("login"),
                        rs.getString("nickname")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }*/

}

   /* public static List<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/post", "postgres",
                    "postgres");
            PreparedStatement st = conn.prepareStatement("select * from post ");
            ResultSet rs = st.executeQuery();
            rs.next();

            while (rs.next()) {
                SimpleUserDAO userDAO = new SimpleUserDAO();
//                userDAO.getUserByName();
//                posts.add(new Post(rs.getString("context"), rs.getString("user_publisher")));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public static List<Film> getFilms() {
        ArrayList<Film> films = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/post", "postgres",
                    "postgres");
            PreparedStatement st = conn.prepareStatement("select * from film ");
            ResultSet rs = st.executeQuery();
            rs.next();

            while (rs.next()) {
                films.add(new Film(rs.getString("description"), rs.getString("name")));
            }
        } catch (
                ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

    public static List<Liked> getLikedFilms() {
        ArrayList<Liked> likedFilms = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/post", "postgres",
                    "postgres");
            PreparedStatement st = conn.prepareStatement("select * from liked ");
            ResultSet rs = st.executeQuery();
            rs.next();

            while (rs.next()) {
//                likedFilms.add(new Film(rs.getString("de"), rs.getString("link")));
            }
        } catch (
                ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return likedFilms;
    }
}

*/
