package com.islandgame.model.animals;

import com.islandgame.model.Predator;

public class Wolf extends Predator {
    private static final double WEIGHT = 50;
    private static final int SPEED = 3;
    private static final double FOOD = 8;
    private static final int MAX = 30;

    public Wolf() {
        super(WEIGHT, SPEED, FOOD, MAX);

        foodMap.put(Rabbit.class, 80);
        foodMap.put(Mouse.class, 60);
        foodMap.put(Deer.class, 15);
        foodMap.put(Goat.class, 20);
        foodMap.put(Sheep.class, 25);
    }

    @Override
    public String getSymbol() {
        return "🐺";
    }
}
