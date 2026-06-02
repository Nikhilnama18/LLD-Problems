package org.nikhil;

import org.nikhil.entities.Game;
import org.nikhil.entities.Player;
import org.nikhil.enums.GameStatus;
import org.nikhil.observer.ScoreBoard;

public final class TicTacToeGame {
    public static  TicTacToeGame instacnce;
    public Game currentGame;
    public ScoreBoard scoreBoard;

    public TicTacToeGame(){
        this.scoreBoard = new ScoreBoard();
    }

    public static TicTacToeGame getInstance(){
        if(instacnce == null){
            instacnce = new TicTacToeGame();
        }
        return instacnce;
    }

    public Game createGame(Player p1, Player p2){
        currentGame = new Game(p1,p2,3);
        currentGame.addObserver(scoreBoard);
        System.out.println("Game started");
        return currentGame;
    }

    public void makeMove(Player player, Integer xPos, Integer yPos){
        if (currentGame == null) {
            throw new IllegalStateException("No active game. Call createGame first.");
        }
        System.out.println("Player " + player.getName() + " places " + player.getSymbol() + " at " + xPos + ", " + yPos);
        currentGame.makeMove(xPos, yPos);
    }

    public GameStatus getGameStatus() {
        if (currentGame == null) {
            throw new IllegalStateException("No active game.");
        }
        return currentGame.getStatus();
    }

    public void printScoreBoard(){
        scoreBoard.printScoreboard();
    }
}
