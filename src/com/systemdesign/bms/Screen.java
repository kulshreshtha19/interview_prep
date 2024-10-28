package com.systemdesign.bms;

import java.util.List;

public class Screen {

    private List<Seat> seatList;

    private String screenId;

    Screen(List<Seat> seatList, String screenId) {
        this.seatList = seatList;
        this.screenId = screenId;
    }

    public Seat getSeatById(String seatId) {
        for (Seat seat : seatList) {
            if (seat.getSeatId().equals(seatId))
                return seat;
        }

        return null;
    }
 }
