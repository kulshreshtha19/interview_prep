package com.systemdesign.tictactoe;

public class Board {

    PieceType[][] board;

    int size;

    public Board(int size) {
        this.size = size;
        board = new PieceType[size][size];
    }

    public void printBoard() {
        for (int i=0;i<size;i++) {
            for (int j=0;j<size-1;j++) {
                System.out.print((board[i][j] == null ? " " : board[i][j].name()) + "|");
            }
            System.out.print((board[i][size-1] == null ? " " : board[i][size-1].name()));
            System.out.println();
        }
    }

    public Boolean addPiece(PieceType pieceType, Move move) {
        Boolean isValidMove = checkMoveValidity(move);
        if (isValidMove) {
            board[move.getI()][move.getJ()] = pieceType;
        }
        return isValidMove;
    }

    private Boolean checkMoveValidity(Move move) {
        return move.getI() >= 0
                && move.getI() < size && move.getJ() >= 0 && move.getJ() < size && board[move.getI()][move.getJ()] == null;
    }

    public Boolean checkFreeSpace() {
        boolean isFreeSpace = false;
        for (int i = 0;i < size;i++) {
            for (int j = 0;j<size;j++) {
                if (board[i][j] == null) {
                    return true;
                }
            }
        }
        return isFreeSpace;
    }
}
