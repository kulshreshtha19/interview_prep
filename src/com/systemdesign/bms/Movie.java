package com.systemdesign.bms;

public class Movie {

    private String name;

    private String description;

    private City city;

    Movie(String name, String description, City city) {
        this.name = name;
        this.description = description;
        this.city = city;
    }

    public City getCity() {
        return this.city;
    }

    public String getName() {
        return this.name;
    }
}
