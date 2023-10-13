package org.example.model;

import java.io.Serializable;

public class Session implements Serializable {
    private Movie movie;
    private Theater theater;
    private String time;

    public Session(Movie movie, Theater theater, String time) {
        this.movie = movie;
        this.theater = theater;
        this.time = time;
    }

    @Override
    public String toString() {
        return this.movie + "\n" + this.theater + "\nla sesión empieza a las " + this.time;
    }
}
