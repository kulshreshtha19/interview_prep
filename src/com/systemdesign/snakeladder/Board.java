package com.systemdesign.snakeladder;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private int[] board;

    private Map<Integer, Integer> snake;

    private Map<Integer, Integer> ladder;

    private Integer winningPosition;

    public Board(Integer winningPosition, Integer boardSize) {
        this.board = new int[boardSize+1];
        this.snake = new HashMap<>();
        this.ladder = new HashMap<>();
        this.winningPosition = winningPosition;
    }

    public void addSnake(Integer start, Integer end) {
        this.snake.put(start, end);
    }

    public void addLadder(Integer start, Integer end) {
        this.ladder.put(start, end);
    }

    public Integer checkSnakeAndLadder(Integer newPosition, Player player) {

        if (this.snake.containsKey(newPosition)) {
            System.out.println(player.getName() + " bitten by snake and new position is " + this.snake.get(newPosition));
            return this.snake.get(newPosition);
        }

        if (this.ladder.containsKey(newPosition)) {
            System.out.println(player.getName() + " used ladder and new position is " + this.ladder.get(newPosition));
            return this.ladder.get(newPosition);
        }

        if (newPosition > this.winningPosition) {
            System.out.println("Invalid position");
            return player.getCurrentPosition();
        }

        return newPosition;
    }

    public Integer getWinningPosition() {
        return this.winningPosition;
    }
}
