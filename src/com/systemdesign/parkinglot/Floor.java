package com.systemdesign.parkinglot;

import java.util.List;

public class Floor {
    private Integer floorNumber;

    private List<ParkingSlot> parkingSlots;

    Floor(Integer floorNumber, List<ParkingSlot> parkingSlots) {
        this.floorNumber = floorNumber;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot findParkingLot(VehicleType vehicleType) {
        for (ParkingSlot parkingSlot : parkingSlots) {
            if (parkingSlot.getIsVacant() && parkingSlot.getVehicleType().equals(vehicleType)) {
                parkingSlot.fill();
                return parkingSlot;
            }
        }

        return null;
    }
}
