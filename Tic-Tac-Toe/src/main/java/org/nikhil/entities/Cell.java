package org.nikhil.entities;

import org.nikhil.enums.Symbol;

public class Cell {
    private Integer id;
    private Symbol symbol;

    private static Integer autoId =1;

    public Cell(){
        this.id= autoId;
        this.symbol = Symbol.EMPTY;
        autoId++;
    }

    public Boolean isEmpty(){
        return this.symbol == Symbol.EMPTY;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
