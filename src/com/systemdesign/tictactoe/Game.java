package com.systemdesign.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    Board board;
    Deque<Player> players;

    Game() {
        initializeGame();
    }

    private void initializeGame() {
        players = new LinkedList<>();

        Player p1 = new Player(PieceType.X, "Ramu");
        Player p2 = new Player(PieceType.O, "Shyamu");
        this.players.add(p1);
        this.players.add(p2);

        board = new Board(3);
    }

    public String startGame() {

        boolean winner = true;

        while (winner) {
                Player player = players.removeFirst();
                board.printBoard();

                Boolean isFreeSpace = board.checkFreeSpace();
                if (!isFreeSpace) {
                    winner = false;
                    continue;
                }

                System.out.println(player.getName() + " turn");
                Scanner sc = new Scanner(System.in);
                int i = Integer.parseInt(sc.next());
                int j = Integer.parseInt(sc.next());

                Move move = new Move(i, j);

                Boolean isPieceAdded = board.addPiece(player.getSymbolEnum(), move);
                if (!isPieceAdded) {
                    System.out.println("Invalid Move Please try again");
                    players.addFirst(player);
                    continue;
                }

                Boolean isWinner = checkWinner(player, move);
                if (isWinner) {
                    return "Winner is " + player.getName();
                }
                players.addLast(player);
            }
             return "Game is Tie";
        }

    private Boolean checkWinner(Player player, Move move) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Row Match
        for (int i = 0; i < board.size; i++) {
            if(board.board[move.getI()][i] != player.getSymbolEnum()) {
                rowMatch = false;
                break;
            }
        }

        // Column Match
        for (int i = 0; i < board.size; i++) {
            if(board.board[i][move.getJ()] != player.getSymbolEnum()) {
                columnMatch = false;
                break;
            }
        }

        // Diagonal Match
        for (int i = 0; i < board.size; i++) {
            if(board.board[i][i] != player.getSymbolEnum()) {
                diagonalMatch = false;
                break;
            }
        }


        // AntiDiagonal Match
        for (int i = 0; i < board.size; i++) {
            if(board.board[board.size - i - 1][i] != player.getSymbolEnum()) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
    }
