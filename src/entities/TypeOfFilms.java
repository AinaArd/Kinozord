package entities;

import java.util.ArrayList;

public class TypeOfFilms {
    private String name;
    private ArrayList<Film> films;

    public TypeOfFilms(String name, ArrayList<Film> films) {
        this.name = name;
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }
}

