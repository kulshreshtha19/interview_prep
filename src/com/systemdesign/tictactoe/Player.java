package com.systemdesign.tictactoe;

public class Player {

    private PieceType pieceType;

    private String name;

    public Player(PieceType pieceType, String name) {
        this.pieceType = pieceType;
        this.name = name;
    }

    public PieceType getSymbolEnum() {
        return this.pieceType;
    }

    public String getName() {
        return name;
    }
}
