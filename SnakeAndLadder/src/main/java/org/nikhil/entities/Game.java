package org.nikhil.entities;

import org.nikhil.exception.NotEnoughPlayers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private Board board;
    private List<Player>players;
    private Dice dice;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Integer currentPlayerIndex = -1;
    private GameStatus gameStatus;

    public void createGame(){
        players = new ArrayList<>();
        ladders = new ArrayList<>();
        snakes = new ArrayList<>();
        dice = new Dice();
        initializeSnakes();
        initializeLadders();
        board = new Board(100, snakes, ladders);
        gameStatus = GameStatus.CREATED;
    }

    public void addPlayer(Player p){
        players.add(p);
        return ;
    }

    public void startGame(){
        if(players.size()<2){
            throw new NotEnoughPlayers("Not enough players to start the game");
        }

        System.out.println("Let's start the page, roll the dice");
        currentPlayerIndex = 0;
        gameStatus = GameStatus.STARTED;
    }

    public void move(){
        if(currentPlayerIndex == -1){
            throw new RuntimeException("Game must be started before making a move");
        }

        if(gameStatus == GameStatus.FINISHED){
            throw  new RuntimeException("This game is finished, start a new game by resetting the game");
        }

        gameStatus = GameStatus.IN_PROGRESS;

        Player player  = players.get(currentPlayerIndex);
        Integer diceNumber = dice.roll();

        System.out.println("Dice roll is "  + diceNumber);

        Integer curPos = player.getPosition();
        Integer newPos = board.move(curPos, diceNumber);
        player.setPosition(newPos);



        System.out.println("Player " + player.getName() + " moved from " + curPos + " to " + newPos);
        if(newPos == 100){
            gameStatus = GameStatus.FINISHED;
            System.out.println("Player " + player.getName() + " won the game");
        }
        currentPlayerIndex++;
        if(currentPlayerIndex == players.size())
            currentPlayerIndex = 0;
    }

    public void getPlayerPositions(){
        System.out.println("Player positions");
        players.forEach((player -> {
            System.out.println("Player" + player.getName() + " is at " + player.getPosition());
        }));
        System.out.println("--------------------");
    }


    public void initializeSnakes(){
        Snake s1 = new Snake(32,10);
        Snake s2 = new Snake(36,6);
        Snake s3 = new Snake(43,11);
        Snake s4 = new Snake(62,19);
        Snake s5 = new Snake(87,24);
        Snake s6 = new Snake(95,75);
        Snake s7 = new Snake(99,54);
        Collections.addAll(snakes, s1, s2, s3, s4,s5, s6, s7);
    }
    public void initializeLadders(){
        Ladder l1 = new Ladder(4, 14);
        Ladder l2 = new Ladder(9,31);
        Ladder l3 = new Ladder(21,42);
        Ladder l4 = new Ladder(28,84);
        Ladder l5 = new Ladder(51,67);
        Ladder l6 = new Ladder(72,91);
        Ladder l7 = new Ladder(80,100);
        Collections.addAll(ladders , l1, l2, l3, l4, l5, l6, l7);
    }

    public void resetGame(){
        players.forEach((player -> {
            player.setPosition(0);
        }));
        currentPlayerIndex = -1;
    }
}
