package org.nikhil.exception;

public class NotEnoughPlayers extends RuntimeException{
    public NotEnoughPlayers(String message){
        super(message);
    }
}
