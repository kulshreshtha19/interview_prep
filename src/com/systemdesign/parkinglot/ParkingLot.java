package com.systemdesign.parkinglot;

import com.systemdesign.parkinglot.payments.ParkingFeeStrategyContext;
import com.systemdesign.parkinglot.payments.SecondlyFeeCalculator;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingLot {

    private List<Floor> floorList;

    ParkingLot(List<Floor> floorList) {
        this.floorList = floorList;
    }

    private synchronized ParkingSlot getParkingSlot(Vehicle vehicle) {
        ParkingSlot parkingSlot = null;
        for (Floor floor : floorList) {
            parkingSlot = floor.findParkingLot(vehicle.getVehicleType());
            if (parkingSlot != null) {
                return parkingSlot;
            }
        }
        return null;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSlot parkingSlot = getParkingSlot(vehicle);
        if (parkingSlot == null) {
            System.out.println("No parking space available for vehicle type " + vehicle.getVehicleType());
            return null;
        }

        Ticket ticket = new Ticket(vehicle, parkingSlot);
        System.out.println(Thread.currentThread().getName() +  " Parking Slot allotted with details "+ ticket);
        return ticket;
    }

    public synchronized void exitVehicle(Ticket ticket) {
        if (ticket == null) {
            return;
        }
        ticket.setEndTime(LocalDateTime.now());
        ticket.getParkingSlot().vacate();

        ParkingFeeStrategyContext parkingFeeStrategyContext = new ParkingFeeStrategyContext(new SecondlyFeeCalculator());
        float parkingFee = parkingFeeStrategyContext.calculateParkingFee(ticket);
        System.out.println("Vehicle exited from parking with details " + ticket + " amount " + parkingFee);
    }
}
