package org.nikhil.entities;

import org.nikhil.exception.InvalidSnakeOrLadder;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell>board;
    private Integer size;

    public Board(Integer size, List<Snake> snakes, List<Ladder> ladders){
        this.size = size;
        board = new ArrayList<>();
        initializeBoard(snakes, ladders);
    }

    private void initializeBoard(List<Snake> snakes, List<Ladder> ladders){

        for(Integer i=0; i<size; i++){
            Integer curIndex = i+1;
            Snake snake = snakes.stream().filter(curSnake-> curSnake.getStratPos() == curIndex)
                    .findFirst().orElse(null);

            Ladder ladder = ladders.stream().filter(curLadder-> curLadder.getStratPos() == curIndex)
                    .findFirst().orElse(null);

            if(snake != null && ladder != null){
                throw new InvalidSnakeOrLadder("Snake and Ladder can`t be at same position");
            }
//            System.out.println("Snake size is " + snakes.size());

            if(snake != null || ladder != null){
                SpecailMover sm = snake != null ? snake: ladder;
                board.add(new Cell(curIndex, true, sm.getMoveResult()));
            }
            board.add(new Cell(curIndex));
        }

    }

    public Integer move(Integer curPos, Integer moveBy){
        // Implement logic to give the new position keeping snake and ladders in mind
        if(curPos + moveBy > size){
            System.out.println("Out of boundary");
            return curPos;
        }

        int newPos = curPos + moveBy;

        Cell newPosCell = board.get(newPos - 1);
        newPos = curPos + moveBy + newPosCell.getMove();


        if(newPosCell.getSpecial() && newPosCell.getMove() > 0){
            System.out.println("User has taken a ladder");
        }
        if(newPosCell.getSpecial() && newPosCell.getMove() <0){
            System.out.println("User is bitten by a snake");
        }

        return newPos;
    }


}
