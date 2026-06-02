package org.nikhil;

import org.nikhil.entities.Game;
import org.nikhil.entities.Player;

public class SnakeAndLaddersGame {
    private Game game;
    public SnakeAndLaddersGame(){
        game = new Game();
        game.createGame();
    }

    public void createPlayer(String name){
        Player player = new Player(name);
        game.addPlayer(player);
    }

    public void startGame(){
        game.startGame();
    }

    public void resetGame(){
        game.resetGame();
    }

    public void rollDice(){
        game.move();
    }

    public void getPlayerPositions(){
        game.getPlayerPositions();
    }
}
