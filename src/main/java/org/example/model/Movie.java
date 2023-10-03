package org.example.model;

/*
    Should define the class for the concepts Movie, Theater and Session.
    A session is a play of movie in a theater.
    Create 2 instances of each class and relate among them.
    Serialize to Json all objects and save then in different files.
 */
public class Movie {
    private String title;
    private int duration;

    public Movie(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
}
