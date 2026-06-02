package org.nikhil.exception;

public class InvalidSnakeOrLadder extends RuntimeException{
    public InvalidSnakeOrLadder(String message){
        super(message);
    }
}
