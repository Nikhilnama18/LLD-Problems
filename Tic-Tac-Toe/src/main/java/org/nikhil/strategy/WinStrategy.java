package org.nikhil.strategy;

import org.nikhil.entities.Board;
import org.nikhil.enums.Symbol;

public interface WinStrategy {
    public Boolean hasWon(Board board, Symbol symbol);
}
