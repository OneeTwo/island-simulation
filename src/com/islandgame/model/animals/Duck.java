package com.islandgame.model.animals;

import com.islandgame.model.Herbivore;

public class Duck extends Herbivore {
    private static final double WEIGHT = 1;
    private static final int SPEED = 2;
    private static final double FOOD = 0.15;
    private static final int MAX = 200;

    public Duck() {
        super(WEIGHT, SPEED, FOOD, MAX);
    }

    @Override
    public String getSymbol() {
        return "🦆";
    }
}
