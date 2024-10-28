package com.systemdesign.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class Ticket {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String ticketId;

    private Vehicle vehicle;

    private ParkingSlot parkingSlot;

    Ticket(Vehicle vehicle, ParkingSlot parkingSlot) {
        this.startTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.ticketId = UUID.randomUUID().toString();
        this.parkingSlot = parkingSlot;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ParkingSlot getParkingSlot() {
        return this.parkingSlot;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    @Override
    public String toString() {
        return this.ticketId + " " + this.vehicle.getVehicleType() + " " + this.getVehicle().getVehicleNumber()
                + " " + this.parkingSlot.getSlotId() + " " + this.startTime + " " + this.endTime;
    }

    public long getTimeSpent() {
        return Duration.between(startTime, endTime).toMillis();
    }
}
