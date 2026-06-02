package org.nikhil.models;

import org.nikhil.enums.VehicleType;

import java.util.UUID;

public class Vehicle {

    private final String vehicleId;
    private final VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType){
        this.vehicleId = UUID.randomUUID().toString();
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
