package org.nikhil.strategy;

import org.nikhil.entities.Board;
import org.nikhil.enums.Symbol;

public class CrossWinStrategy implements WinStrategy{
    @Override
    public Boolean hasWon(Board board, Symbol symbol) {
        Boolean won =true;

        for(int i=0; i<board.getSize(); i++){
            if(board.getGameboard()[i][i].getSymbol() != symbol){
                won = false;
                break;
            }
        }

        if(won==true){
            return true;
        }
        won = true;

        for(int i=0; i< board.getSize(); i++){
            if(board.getGameboard()[(board.getSize() - i -1)][i].getSymbol() !=symbol){
                return  false;
            }
        }

        return true;
    }
}
