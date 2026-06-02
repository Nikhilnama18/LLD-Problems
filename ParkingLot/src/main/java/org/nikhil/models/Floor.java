package org.nikhil.models;

import org.nikhil.enums.VehicleType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Floor {
    private final int floor;
    private final Map<String ,Spot> spots;

    public Floor(int floorNumber) {
        this.floor = floorNumber;
        this.spots = new ConcurrentHashMap<>();
    }

    public void addSpot(Spot spot){
        spots.put(spot.getSlotId(), spot);
    }


}
