package org.nikhil.models;

import java.util.Date;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final Spot spot;
    private final Vehicle vehicle;
    private final long entryTime;
    private long exitTime;

    public Ticket(Spot spot, Vehicle vehicle) {
        this.ticketId = UUID.randomUUID().toString();
        this.spot = spot;
        this.vehicle = vehicle;
        this.entryTime = new Date().getTime();
    }

    public void setExitTime() {
        this.exitTime = new Date().getTime();
    }

    public Spot getSpot() {
        return spot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }
}
