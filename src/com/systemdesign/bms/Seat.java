package com.systemdesign.bms;

public class Seat {

    private String seatId;
    private SeatType seatType;

    private Integer price;

    Seat(String seatId, SeatType seatType, Integer price) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.price = price;
    }

    public String getSeatId() {
        return this.seatId;
    }
}
