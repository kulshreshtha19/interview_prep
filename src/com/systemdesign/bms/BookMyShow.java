package com.systemdesign.bms;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookMyShow {

    private TheatreService theatreService;

    private MovieService movieService;

    private final Lock lock = new ReentrantLock();

    BookMyShow() {
        this.theatreService = new TheatreService();
        this.movieService = new MovieService();
    }

    public void initialize() {
        // Creating Movies
        Movie movie1 = new Movie("BHOOL BHULAIYA", "BHOOL BHULAIYA HORROR", City.BANGALORE);
        Movie movie2 = new Movie("Fast and Furious 3", "Fast and Furious 3", City.BANGALORE);


        // Creating Seats, Screens & Theatres
        Seat seat1 = new Seat("A1", SeatType.GOLD, 90);
        Seat seat2 = new Seat("A2", SeatType.PLATINUM, 150);
        Screen screen1 = new Screen(List.of(seat1, seat2), "Screen1");

        Seat seat3 = new Seat("A1", SeatType.GOLD, 90);
        Seat seat4 = new Seat("A2", SeatType.PLATINUM, 150);
        Screen screen2 = new Screen(List.of(seat3, seat4), "Screen2");

        Theatre theatre1 = new Theatre("INOX BANGALORE", "NEAR SUBHASH NAGAR"
                , City.BANGALORE, List.of(screen1, screen2));


        // Creating Shows
        Show show = new Show(movie1, "9", "12", screen1);
        Show show1 = new Show(movie1, "13", "14", screen1);
        theatre1.addShow(show);
        theatre1.addShow(show1);


        this.theatreService.addTheatreToCity(theatre1.getCity(), theatre1);
        this.movieService.addMovieToCity(movie1.getCity(), movie1);
        this.movieService.addMovieToCity(movie2.getCity(), movie2);
    }

    public void startBooking() {

        ExecutorService executors = Executors.newFixedThreadPool(2);
        try {
            Future<Void> future1 = executors.submit(() -> {
                createBooking("A1");
                return null;
            });

            Future<Void> future2 = executors.submit(() -> {
                createBooking("A1");
                return null;
            });

            future1.get();
            future2.get();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            executors.shutdown();
        }


//        createBooking(this.theatreList.get(0), this.theatreList.get(0).getShows().get(0)
//                , "A1");
//        createBooking(this.theatreList.get(0), this.theatreList.get(0).getShows().get(1), "A1");
    }

    private void createBooking(String seatId) {

        // Fetching cities
        List<City> cityList = theatreService.getCities();

        if (cityList.isEmpty()) {
            System.out.println("No cities exist where theatres are available");
            return;
        }

        // Suppose user chooses Bangalore
        List<Movie> movieList = movieService.getMovieByCity(cityList.get(0));

        if (movieList.isEmpty()) {
            System.out.println("No movie exist in your city " + cityList.get(0));
            return;
        }

        //Suppose user chooses Bahubali

        Map<Theatre, List<Show>> theatreListMap = theatreService.getShowsBasedOnMovie(movieList.get(0).getCity()
                , movieList.get(0));

        if (theatreListMap.isEmpty()) {
            System.out.println("No shows exist for movie " + movieList.get(0));
        }

        // Suppose user chose INOX theatre and show 1
        Theatre theatre = theatreService.getCityTheatreMap().get(cityList.get(0)).get(0);
        bookSeat(theatre, theatreListMap.get(theatre).get(0), seatId);
    }

    private void bookSeat(Theatre theatre, Show show, String seatId) {
        Seat seat = show.getScreen().getSeatById(seatId);
        if (Objects.isNull(seat))
        {
            System.out.println("No seat available with the passed seatId " + seatId);
            return;
        }

        lock.lock();
        if (show.checkIfSeatAlreadyBooked(seatId)) {
            System.out.println("SeatId " + seatId + " already booked, please try choosing another seat");
            return;
        }

        show.addNewBooking(seat);
        lock.unlock();
        prepareBookingReceipt(theatre, show, seat);
    }

    private void prepareBookingReceipt(Theatre theatre, Show show, Seat seat) {
        Booking booking = new Booking(show.getMovie(), show, theatre, seat);
        System.out.println(booking);
    }


}
