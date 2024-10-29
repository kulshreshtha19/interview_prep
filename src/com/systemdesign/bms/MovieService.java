package com.systemdesign.bms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieService {

    private Map<City, List<Movie>> cityMovieMap;

    MovieService() {
        cityMovieMap = new HashMap<>();
    }

    public void addMovieToCity(City city, Movie movie) {
        if (cityMovieMap.containsKey(city)){
            cityMovieMap.get(city).add(movie);
            return;
        }

        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);
        cityMovieMap.put(city, movieList);
    }

    public List<Movie> getMovieByCity(City city) {
        return cityMovieMap.get(city);
    }
}
