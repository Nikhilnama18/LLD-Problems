package org.nikhil;

public class Main {
    static void main() {
        SnakeAndLaddersGame snakeAndLaddersGame = new SnakeAndLaddersGame();

        snakeAndLaddersGame.createPlayer("Nick");
        snakeAndLaddersGame.createPlayer("Suhas");
        snakeAndLaddersGame.startGame();

        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();
        snakeAndLaddersGame.rollDice();


        snakeAndLaddersGame.getPlayerPositions();
    }
}
