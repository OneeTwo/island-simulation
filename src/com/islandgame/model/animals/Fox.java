package com.islandgame.model.animals;

import com.islandgame.model.Predator;

public class Fox extends Predator {
    private static final double WEIGHT = 8;
    private static final int SPEED = 2;
    private static final double FOOD = 2;
    private static final int MAX = 30;

    public Fox() {
        super(WEIGHT, SPEED, FOOD, MAX);

        foodMap.put(Rabbit.class, 70);
        foodMap.put(Mouse.class, 90);
        foodMap.put(Duck.class, 60);
    }

    @Override
    public String getSymbol() {
        return "🦊";
    }
}
