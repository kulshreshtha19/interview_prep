package com.systemdesign.parkinglot.payments;

import com.systemdesign.parkinglot.Ticket;

public interface ParkingFeeCalculatorStrategy {

    float calculateFee(Ticket ticket);
}
