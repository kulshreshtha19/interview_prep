package com.systemdesign.snakeladder;

import java.util.concurrent.ThreadLocalRandom;

public class Player {

    private final String name;

    private Integer currPosition;

    public Player(String name) {
        this.name = name;
        this.currPosition = 0;
    }

    public void updatePosition(Integer currPosition) {
        this.currPosition = currPosition;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCurrentPosition() {
        return this.currPosition;
    }

    public Integer runDice() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}
