package com.islandgame.model.animals;

import com.islandgame.model.Predator;

public class Eagle extends Predator {
    private static final double WEIGHT = 6;
    private static final int SPEED = 3;
    private static final double FOOD = 1;
    private static final int MAX = 20;

    public Eagle() {
        super(WEIGHT, SPEED, FOOD, MAX);

        foodMap.put(Rabbit.class, 90);
        foodMap.put(Mouse.class, 90);
        foodMap.put(Duck.class, 80);
    }

    @Override
    public String getSymbol() {
        return "🦅";
    }
}
