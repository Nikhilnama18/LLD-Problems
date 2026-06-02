package org.nikhil.strategy;

import org.nikhil.entities.Board;
import org.nikhil.enums.Symbol;

public class ColumnWinStrategy implements WinStrategy{
    @Override
    public Boolean hasWon(Board board, Symbol symbol) {
        for(int i=0; i<board.getSize(); i++){
            Boolean won = true;
            for(int j=0; j<board.getSize(); j++){
                if(board.getGameboard()[j][i].getSymbol() !=symbol){
                    won = false;
                    break;
                }
            }

            if(won == true){
                return true;
            }
        }
        return false;
    }
}
