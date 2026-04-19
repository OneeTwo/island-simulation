package com.islandgame.model.animals;

import com.islandgame.model.Predator;

public class Snake extends Predator {
    private static final double WEIGHT = 15;
    private static final int SPEED = 1;
    private static final double FOOD = 3;
    private static final int MAX = 30;

    public Snake() {
        super(WEIGHT, SPEED, FOOD, MAX);

        foodMap.put(Mouse.class, 80);
        foodMap.put(Rabbit.class, 20);
    }

    @Override
    public String getSymbol() {
        return "🐍";
    }
}
