package com.systemdesign.bms;

import java.util.ArrayList;
import java.util.List;

public class Show {

    private Movie movie;

    private String startTime;

    private String endTime;

    private Screen screen;

    private List<Seat> bookedSeats;

    Show(Movie movie, String startTime, String endTIme , Screen screen) {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTIme;
        this.screen = screen;
        this.bookedSeats = new ArrayList<>();
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public Screen getScreen() {
        return this.screen;
    }

    public Boolean checkIfSeatAlreadyBooked(String seatId) {
        for (Seat seat : this.bookedSeats) {
            if (seat.getSeatId().equals(seatId)) {
                return true;
            }
        }
        return false;
    }

    public void addNewBooking(Seat seat) {
        this.bookedSeats.add(seat);
    }

    public Movie getMovie() {
        return this.movie;
    }
}
