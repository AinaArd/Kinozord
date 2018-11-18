package entities;

public class Film {
    private long id;
    private String description;
    private String name;
    private int year;
    private String country;
    private int rate;
    private String pic;
    private String category;

    public Film() {

    }

    public Film(long id, String description, String name, int year, String country, int rate, String pic) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.year = year;
        this.country = country;
        this.rate = rate;
        this.pic = pic;
    }

    public Film(long id, String description, String name, int year, String country, int rate, String pic, String category) {
        this(id,description,name,year,country,rate,pic);
        this.category = category;
    }

    public Film(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", rate=" + rate +
                '}';
    }
}
