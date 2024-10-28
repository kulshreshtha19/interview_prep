package com.systemdesign.parkinglot;

public class Vehicle {

    private VehicleType vehicleType;

    private String vehicleNumber;

    Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
