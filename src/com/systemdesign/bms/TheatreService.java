package com.systemdesign.bms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreService {

    private Map<City, List<Theatre>> cityTheatreMap;

    TheatreService() {
        cityTheatreMap = new HashMap<>();
    }

    public void addTheatreToCity(City city, Theatre theatre) {
        if (cityTheatreMap.containsKey(city)){
            cityTheatreMap.get(city).add(theatre);
            return;
        }

        List<Theatre> theatreList = new ArrayList<>();
        theatreList.add(theatre);
        cityTheatreMap.put(city, theatreList);
    }

    public Map<City, List<Theatre>> getCityTheatreMap() {
        return this.cityTheatreMap;
    }

    public List<City> getCities() {
       return new ArrayList<>(this.cityTheatreMap.keySet());
    }

    public Map<Theatre, List<Show>> getShowsBasedOnMovie(City city ,Movie movie) {
        Map<Theatre, List<Show>> theatreListMap = new HashMap<>();

        List<Theatre> theatres = cityTheatreMap.get(city);
        for (Theatre theatre : theatres) {
            List<Show> showList = theatre.getShows();
            List<Show> filteredShow =  showList.stream().filter(s -> s.getMovie().equals(movie)).toList();

            if (!filteredShow.isEmpty())
                theatreListMap.put(theatre, filteredShow);
        }

        return theatreListMap;
    }
}
