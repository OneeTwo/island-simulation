package com.islandgame.model.animals;

import com.islandgame.model.Predator;

public class Bear extends Predator {
    private static final double WEIGHT = 300;
    private static final int SPEED = 2;
    private static final double FOOD = 80;
    private static final int MAX = 5;

    public Bear() {
        super(WEIGHT, SPEED, FOOD, MAX);

        foodMap.put(Rabbit.class, 80);
        foodMap.put(Deer.class, 80);
        foodMap.put(Goat.class, 70);
        foodMap.put(Sheep.class, 70);
        foodMap.put(Boar.class, 50);
    }

    @Override
    public String getSymbol() {
        return "🐻";
    }
}
