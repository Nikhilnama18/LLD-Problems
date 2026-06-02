package org.nikhil.service;

import org.nikhil.models.Floor;
import org.nikhil.models.Spot;
import org.nikhil.models.Ticket;
import org.nikhil.models.Vehicle;
import org.nikhil.strategy.FeeStrategy;
import org.nikhil.strategy.FlatRateFee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLotService {
    private static ParkingLotService instance;
    private final List<Floor> floors;
    private final Map<String, Ticket> tickets;
    private FeeStrategy feeStrategy;

    private ParkingLotService() {
        this.feeStrategy = new FlatRateFee();
        this.floors = new ArrayList<>();
        this.tickets = new ConcurrentHashMap<>();
    }

    public static ParkingLotService getInstance(){
        if(instance == null){
            instance = new ParkingLotService();
        }
        return  instance;
    }

    public void addFloor(Floor floor){
        this.floors.add(floor);
    }

    public Optional<Ticket> parkVehicle(Vehicle vehicle){
        Optional<Spot> availableSpot = this.findSpot(this.floors, vehicle);

        if(availableSpot.isPresent()){
            Spot spot = availableSpot.get();
            spot.parkVehicle(vehicle);
            Ticket ticket = new Ticket(spot, vehicle);
            tickets.put(vehicle.getVehicleId(), ticket);
            return Optional.of(ticket);
        }

        return Optional.empty();
    }

    public Optional<Double> unparkVehicle(String vehicleId){
        Ticket ticket = tickets.remove(vehicleId);

        if(ticket == null){
            System.out.println("Ticket not found");
            return Optional.empty();
        }

        ticket.setExitTime();
        ticket.getSpot().unparkVehicle();
        Double fee = feeStrategy.getFee(ticket);
        return Optional.of(fee);
    }

    private Optional<Spot> findSpot(List<Floor> floors, Vehicle vehicle){
        for (Floor floor: floors){
            Optional<Spot> spot = floor.getAvailableSpot(vehicle);
            if(spot.isPresent()){
                return spot;
            }
        }
        return Optional.empty();
    }
}
