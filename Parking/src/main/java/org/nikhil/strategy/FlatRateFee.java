package org.nikhil.strategy;

import org.nikhil.models.Ticket;

public class FlatRateFee implements FeeStrategy{

    private static final double FEE_FOR_HOUR = 12;

    @Override
    public double getFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getEntryTime();
        long hours = (duration / 1000*60*60) + 1;
        return FEE_FOR_HOUR * hours;
    }
}
