package entities;

public class Film {
    private long id;
    private String description;
    private String name;
    private int year;
    private String country;
    private int rate;

    public Film(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Film(long id, int year, String country, int rate, String description, String name) {
        this(description, name);
        this.id = id;
        this.year = year;
        this.country = country;
        this.rate = rate;
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
