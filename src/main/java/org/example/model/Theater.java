package org.example.model;

import java.io.Serializable;

public class Theater implements Serializable {
    private String name;
    private String location;

    public Theater(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Teatro: " + this.name + "\nLugar: " + this.location;
    }
}
