package com.systemdesign.snakeladder;

import com.systemdesign.snakeladder.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    Board board;

    List<Player> players;

    public Game() {
        this.board = new Board(100, 100);
        this.players = new ArrayList<>();
    }

    public void initializeGame() {
        System.out.println("...Initializing Game...");
        // Adding Snake
        board.addSnake(6, 1);
        board.addSnake(99, 50);

        //Adding Ladders
        board.addLadder(40, 98);
        board.addLadder(5, 10);

        Player player1 = new Player("RedEagle");
        Player player2 = new Player("Shyam");
        players.add(player1);
        players.add(player2);

        System.out.println("....Game is initialized....");
    }

    public void startGame() {
        boolean isGameEnded = false;
        while (!isGameEnded) {
            for (Player player : players) {
                System.out.println(player.getName() + " chance.....");
                Integer dicedNumber = player.runDice();
                System.out.println(player.getName() + " got " + dicedNumber + " and current position is " + player.getCurrentPosition());
                Integer updatedNewPosition = board
                        .checkSnakeAndLadder(player.getCurrentPosition() + dicedNumber, player);
                System.out.println(player.getName() + " moved to " + updatedNewPosition);
                player.updatePosition(updatedNewPosition);
                if (Objects.equals(updatedNewPosition, board.getWinningPosition())){
                    System.out.println(player.getName() + " won the game");
                    isGameEnded = true;
                    break;
                }
            }
        }
    }
}
