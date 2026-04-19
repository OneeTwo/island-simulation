package com.islandgame.model.animals;

import com.islandgame.model.Herbivore;

public class Horse extends Herbivore {
    private static final double WEIGHT = 400;
    private static final int SPEED = 4;
    private static final double FOOD = 60;
    private static final int MAX = 20;

    public Horse() {
        super(WEIGHT, SPEED, FOOD, MAX);
    }

    @Override
    public String getSymbol() {
        return "🐎";
    }
}
