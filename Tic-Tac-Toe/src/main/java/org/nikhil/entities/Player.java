package org.nikhil.entities;

import org.nikhil.enums.Symbol;

public class Player {
    private Integer id;
    private String name;
    private Symbol symbol;

    private static Integer autoId=1;

    public Player(String name, Symbol symbol){
        this.id = autoId;
        this.name = name;
        this.symbol = symbol;
        autoId++;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
