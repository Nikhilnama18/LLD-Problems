package org.nikhil.entities;

import org.nikhil.enums.GameStatus;
import org.nikhil.exceptions.InvalidMoveException;
import org.nikhil.observer.Observer;
import org.nikhil.strategy.ColumnWinStrategy;
import org.nikhil.strategy.CrossWinStrategy;
import org.nikhil.strategy.RowWinStrategy;
import org.nikhil.strategy.WinStrategy;
import org.nikhil.enums.Symbol;

import java.util.List;

public class Game {
    private Board board;
    private Player[] players;
    private Symbol currentPlayerSymbol;
    private Integer currentPlayerIndex;
    private GameStatus status;
    private List<WinStrategy> winStrategies;
    private List<Observer>observers;

    public Game(Player player1, Player player2, Integer size){
        this.players = new Player[]{player1, player2};
        board = new Board(size);
//        currentPlayerSymbol = Symbol.X;
        currentPlayerIndex = 0;
        this.status = GameStatus.IN_PROGRESS;
        this.registerWinStrategy();

    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    private void registerWinStrategy(){
        this.winStrategies.add(new RowWinStrategy());
        this.winStrategies.add(new ColumnWinStrategy());
        this.winStrategies.add(new CrossWinStrategy());
    }

    public void makeMove(Integer xPos, Integer yPos){
        if(status != GameStatus.IN_PROGRESS){
            throw new InvalidMoveException("Game has not started yet");
        }

        if(this.board.isCellOccupied(xPos, yPos)){
            throw new InvalidMoveException("Cell is already filled with symbol");
        }

        Player curPlayer = players[currentPlayerIndex];

        this.board.makeMove(xPos, yPos, curPlayer.getSymbol());

        if(checkWin(curPlayer.getSymbol())){
            setStatus(curPlayer.getSymbol() == Symbol.X ? GameStatus.WON_BY_X : GameStatus.WON_BY_O);
            notifyObservers();
            return ;
        }

        if(board.isFull()){
            setStatus(GameStatus.DRAW);
            notifyObservers();
            return ;
        }

        currentPlayerIndex = currentPlayerIndex == 0 ? 1: 0;
    }

    private void notifyObservers(){
        for(Observer observer: observers){
            observer.update(this);
        }
    }

    public Player getWinner(){
        if(status == GameStatus.WON_BY_X){
            return players[0].getSymbol() == Symbol.X ? players[0] : players[1];
        } else if (status == GameStatus.WON_BY_O) {
            return players[0].getSymbol() == Symbol.O ? players[0] : players[1];
        }
        return null;

    }


    public GameStatus getStatus() {
        return status;
    }

    private Boolean checkWin(Symbol symbol){

        for(WinStrategy winStrategy : this.winStrategies){
            if(winStrategy.hasWon(this.board, symbol)){
                return true;
            }
        }
        return false;
    }

    private void setStatus(GameStatus status) {
        this.status = status;
    }


}
