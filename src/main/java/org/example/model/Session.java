package org.example.model;

public class Session {
    private Movie movie;
    private Theater theater;
    private String time;

    public Session(Movie movie, Theater theater, String time) {
        this.movie = movie;
        this.theater = theater;
        this.time = time;
    }
}
