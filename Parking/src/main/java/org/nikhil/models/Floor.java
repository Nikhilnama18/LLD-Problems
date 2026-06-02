package org.nikhil.models;

import org.nikhil.enums.VehicleType;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Floor {
    private final Integer floorNumber;
    private Map<String, Spot> spots;

    public Floor(Integer floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ConcurrentHashMap<>();
    }

    public void addSpot(Spot spot){
        spots.put(spot.getSpotId(), spot);
    }

    public Optional<Spot> getAvailableSpot(Vehicle vehicle){
        return spots.values().stream()
                .filter(spot -> {
                    return spot.canPark(vehicle);
                }).findFirst();
    }
}
