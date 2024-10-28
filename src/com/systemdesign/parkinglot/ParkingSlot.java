package com.systemdesign.parkinglot;

public class ParkingSlot {

    private Integer slotId;

    private VehicleType vehicleType;

    private Boolean isVacant;

    private Integer price;

    ParkingSlot(VehicleType vehicleType, Integer price, Integer slotId) {
        this.vehicleType = vehicleType;
        this.isVacant = true;
        this.price = price;
        this.slotId = slotId;
    }

    public Boolean getIsVacant() {
        return this.isVacant;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public void vacate() {
        this.isVacant = true;
    }

    public void fill() {
        this.isVacant = false;
    }

    public Integer getSlotId() {
        return this.slotId;
    }

    public Integer getPrice() {
        return this.price;
    }
}
