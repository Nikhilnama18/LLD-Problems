package org.nikhil.entities;

public class Cell {
    private Integer id;
    private Boolean isSpecial;
    private Integer move;

    public Cell(Integer id){
        this.id = id;
        this.isSpecial = false;
        this.move = 0;
    }

    public Cell(Integer id, Boolean isSpecial, Integer move){
        this.id = id;
        this.isSpecial = isSpecial;
        this.move = move;

    }

    public Integer getId() {
        return id;
    }

    public Boolean getSpecial() {
        return isSpecial;
    }

    public Integer getMove() {
        return move;
    }
}
