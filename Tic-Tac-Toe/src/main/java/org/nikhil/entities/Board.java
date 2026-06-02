package org.nikhil.entities;

import org.nikhil.enums.Symbol;

public class Board {
    private Cell[][] gameboard;
    private Integer size;

    public Board(Integer size){
        this.size = size;
        this.initializeBoard();
    }

    public Integer getSize() {
        return size;
    }

    public Cell[][] getGameboard() {
        return gameboard;
    }

    private void initializeBoard(){
        gameboard = new Cell[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                gameboard[i][j] = new Cell();
            }
        }
        // register Scoreboard
    }

    public void makeMove(int xPos, int yPos, Symbol symbol){
        this.gameboard[xPos][yPos].setSymbol(symbol);
    }

    public Boolean isFull(){
        for(int i=0; i<getSize(); i++){
            for(int j=0; j<getSize(); j++){
                if(this.gameboard[i][j].getSymbol() ==Symbol.EMPTY)
                    return false;
            }
        }
        return true;
    }

    public Boolean isCellOccupied(int xPos, int yPos){
        return this.gameboard[xPos][yPos].getSymbol() != Symbol.EMPTY;
    }
}
