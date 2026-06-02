package org.nikhil.models;

import org.nikhil.enums.VehicleType;

import java.util.UUID;

public class Spot {
    private final String slotId;
    private final VehicleType vehicleType;
    private Vehicle vehicle;

    public Spot(VehicleType vehicleType) {
        this.slotId = UUID.randomUUID().toString();
        this.vehicleType = vehicleType;
    }

    public String getSlotId() {
        return slotId;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }

    public synchronized void unparkVehicle(){
        this.vehicle = null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean canParkVehicle(Vehicle vehicle){
        if(!this.isAvailable()){
            return false;
        }

        return vehicle.getVehicleType() == this.getVehicleType();
    }
}
