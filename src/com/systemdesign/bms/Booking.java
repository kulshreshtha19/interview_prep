package com.systemdesign.bms;

public class Booking {

    private Movie movie;

    private Show show;

    private Theatre theatre;

    private String id;

    private Seat seat;

    Booking(Movie movie, Show show, Theatre theatre, Seat seat) {
        this.movie = movie;
        this.show = show;
        this.theatre = theatre;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket for movie " + movie.getName() + " has been booked, seat details are:" + seat.getSeatId() + " with time "
                + show.getStartTime() + " " + show.getEndTime() + " at" + theatre.getCity();
    }
}
