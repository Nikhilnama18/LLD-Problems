package org.nikhil.strategy;

import org.nikhil.models.Ticket;

public interface FeeStrategy {
    public double getFee(Ticket ticket);
}
