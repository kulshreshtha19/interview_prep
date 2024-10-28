package com.systemdesign.parkinglot.payments;

import com.systemdesign.parkinglot.Ticket;

public class ParkingFeeStrategyContext {

    private ParkingFeeCalculatorStrategy parkingFeeCalculatorStrategy;

    public ParkingFeeStrategyContext(ParkingFeeCalculatorStrategy parkingFeeCalculatorStrategy) {
        this.parkingFeeCalculatorStrategy = parkingFeeCalculatorStrategy;
    }

    public float calculateParkingFee(Ticket ticket) {
        return this.parkingFeeCalculatorStrategy.calculateFee(ticket);
    }
}
