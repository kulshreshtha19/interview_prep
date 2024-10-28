package com.systemdesign.parkinglot.payments;

import com.systemdesign.parkinglot.Ticket;

public class SecondlyFeeCalculator implements ParkingFeeCalculatorStrategy{
    @Override
    public float calculateFee(Ticket ticket) {
        Integer parkingPrice = ticket.getParkingSlot().getPrice();
        long totalTimeSpent = ticket.getTimeSpent()/1000;
        return (float) (totalTimeSpent * parkingPrice);
    }
}
