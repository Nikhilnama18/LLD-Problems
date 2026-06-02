package org.nikhil.models;

import org.nikhil.enums.VehicleType;

import java.util.UUID;

public class Spot {
    private final String spotId;
    private final VehicleType spotType;
    private Vehicle vehicle;

    public Spot(VehicleType spotType) {
        this.spotId = UUID.randomUUID().toString();
        this.spotType = spotType;
    }

    public String getSpotId() {
        return spotId;
    }

    public boolean isAvailable(){
        return this.vehicle == null;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void unparkVehicle(){
        this.vehicle = null;
    }

    public boolean canPark(Vehicle vehicle){
        if(!this.isAvailable()){
            return false;
        }

        return vehicle.getVehicleType() == this.spotType;
    }
}
