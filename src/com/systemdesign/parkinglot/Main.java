package com.systemdesign.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Creating executor service
        ExecutorService executors = Executors.newFixedThreadPool(4);

        try {
            List<Floor> floorList = getFloor();
            ParkingLot parkingLot = new ParkingLot(floorList);


            // Vehicle
            Vehicle vehicle = new Vehicle("HR98K3241", VehicleType.CAR);
//        Ticket ticket = parkingLot.parkVehicle(vehicle);
            Future<Ticket> ticketFuture = executors.submit(() -> parkingLot.parkVehicle(vehicle));

            Vehicle vehicle1 = new Vehicle("HR98K2085", VehicleType.CAR);
//        Ticket ticket1 = parkingLot.parkVehicle(vehicle1);
            Future<Ticket> ticketFuture1 = executors.submit(() -> parkingLot.parkVehicle(vehicle1));

            Vehicle vehicle2 = new Vehicle("HR98K2086", VehicleType.CAR);
//        Ticket ticket2 = parkingLot.parkVehicle(vehicle2);
            Future<Ticket> ticketFuture2 = executors.submit(() -> parkingLot.parkVehicle(vehicle2));

            Vehicle vehicle3 = new Vehicle("HR98K2087", VehicleType.CAR);
//        Ticket ticket3 = parkingLot.parkVehicle(vehicle3);
            Future<Ticket> ticketFuture3 = executors.submit(() -> parkingLot.parkVehicle(vehicle3));

            Vehicle vehicle4 = new Vehicle("HR98K2088", VehicleType.CAR);
//        Ticket ticket4 = parkingLot.parkVehicle(vehicle4);
            Future<Ticket> ticketFuture4 = executors.submit(() -> parkingLot.parkVehicle(vehicle4));

            Ticket ticket = ticketFuture.get();
            Ticket ticket1 =ticketFuture1.get();
            Ticket ticket2 = ticketFuture2.get();
            Ticket ticket3 = ticketFuture3.get();
            Ticket ticket4 = ticketFuture4.get();

//        Thread.sleep(1000);

//        parkingLot.exitVehicle(ticket);
//        parkingLot.exitVehicle(ticket1);
//        parkingLot.exitVehicle(ticket2);
//        parkingLot.exitVehicle(ticket3);
//        parkingLot.exitVehicle(ticket4);

          Future<Void> exit = executors.submit(() -> {
              parkingLot.exitVehicle(ticket);
              return null;
          });

          Future<Void> exit1 = executors.submit(() -> {
                parkingLot.exitVehicle(ticket1);
                return null;
          });

          Future<Void> exit2 = executors.submit(() -> {
                parkingLot.exitVehicle(ticket2);
                return null;
          });

          Future<Void> exit3 = executors.submit(() -> {
                parkingLot.exitVehicle(ticket3);
                return null;
          });

          Future<Void> exit4 = executors.submit(() -> {
                parkingLot.exitVehicle(ticket4);
                return null;
          });

          exit.get();
          exit1.get();
          exit2.get();
          exit3.get();
          exit4.get();

        } catch (InterruptedException | ExecutionException e) {
            throw e;
        } finally {
            executors.shutdown();
        }

    }

    private static List<Floor> getFloor() {
        List<ParkingSlot> parkingSlotListFloor1 = new ArrayList<>();
        ParkingSlot parkingSlot1 = new ParkingSlot(VehicleType.CAR, 90, 1);
        ParkingSlot parkingSlot2 = new ParkingSlot(VehicleType.CAR, 100, 2);
        ParkingSlot parkingSlot3 = new ParkingSlot(VehicleType.CAR, 120, 3);
        parkingSlotListFloor1.add(parkingSlot1);
        parkingSlotListFloor1.add(parkingSlot2);
        parkingSlotListFloor1.add(parkingSlot3);


        List<ParkingSlot> parkingSlotListFloor2 = new ArrayList<>();
        parkingSlot1 = new ParkingSlot(VehicleType.CAR, 90, 4);
        parkingSlot2 = new ParkingSlot(VehicleType.CAR, 100,5);
        parkingSlot3 = new ParkingSlot(VehicleType.CAR, 120,6);
        parkingSlotListFloor2.add(parkingSlot1);
        parkingSlotListFloor2.add(parkingSlot2);
        parkingSlotListFloor2.add(parkingSlot3);

        List<ParkingSlot> parkingSlotListFloor3 = new ArrayList<>();
        parkingSlot1 = new ParkingSlot(VehicleType.CAR, 90,7);
        parkingSlot2 = new ParkingSlot(VehicleType.CAR, 100,8);
        parkingSlot3 = new ParkingSlot(VehicleType.CAR, 120,9);
        parkingSlotListFloor3.add(parkingSlot1);
        parkingSlotListFloor3.add(parkingSlot2);
        parkingSlotListFloor3.add(parkingSlot3);

        List<ParkingSlot> parkingSlotListFloor4 = new ArrayList<>();
        parkingSlot1 = new ParkingSlot(VehicleType.CAR, 90,10);
        parkingSlot2 = new ParkingSlot(VehicleType.CAR, 100,11);
        parkingSlot3 = new ParkingSlot(VehicleType.CAR, 120,12);
        parkingSlotListFloor4.add(parkingSlot1);
        parkingSlotListFloor4.add(parkingSlot2);
        parkingSlotListFloor4.add(parkingSlot3);

        Floor floor1 = new Floor(1, parkingSlotListFloor1);
        Floor floor2 = new Floor(2, parkingSlotListFloor2);
        Floor floor3 = new Floor(3, parkingSlotListFloor3);
        Floor floor4 = new Floor(4, parkingSlotListFloor4);

        List<Floor> floorList = new ArrayList<>();
        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);
        floorList.add(floor4);
        return floorList;
    }
}
