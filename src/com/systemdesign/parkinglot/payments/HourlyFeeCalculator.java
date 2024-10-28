package com.systemdesign.parkinglot.payments;

import com.systemdesign.parkinglot.Ticket;

public class HourlyFeeCalculator implements ParkingFeeCalculatorStrategy{
    @Override
    public float calculateFee(Ticket ticket) {
        Integer parkingPrice = ticket.getParkingSlot().getPrice();
        long totalTimeSpentInSeconds = ticket.getTimeSpent();
        return (float) (totalTimeSpentInSeconds * parkingPrice);
    }
}
