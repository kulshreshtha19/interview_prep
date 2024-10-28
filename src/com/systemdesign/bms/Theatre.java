package com.systemdesign.bms;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private String name;

    private String address;

    private City city;

    private List<Screen> screens;

    private List<Show> shows;

    Theatre(String name, String address, City city, List<Screen> screens) {
        this.screens = screens;
        this.name = name;
        this.address = address;
        this.city = city;
        this.shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        this.shows.add(show);
    }

    public List<Show> getShows() {
        return this.shows;
    }

    public List<Screen> getScreens() {
        return this.screens;
    }

    public City getCity() {
        return this.city;
    }
}
