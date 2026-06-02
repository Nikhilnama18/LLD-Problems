package org.nikhil.models;

import java.util.Date;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final Spot spot;
    private final Vehicle vehicle;
    private final long entryTimeStamp;
    private long existTimeStamp;

    public Ticket(Vehicle vehicle, Spot spot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTimeStamp = new Date().getTime();
    }

    public void setExistTimeStamp() {
        this.existTimeStamp = new Date().getTime();;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Spot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public long getExistTimeStamp() {
        return existTimeStamp;
    }
}
