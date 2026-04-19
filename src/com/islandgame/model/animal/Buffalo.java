package com.islandgame.model.animal;

import com.islandgame.model.Herbivore;

public class Buffalo extends Herbivore {
    private static final double WEIGHT = 700;
    private static final int SPEED = 3;
    private static final double FOOD = 100;
    private static final int MAX = 10;

    public Buffalo() {
        super(WEIGHT, SPEED, FOOD, MAX);
    }

    @Override
    public String getSymbol() {
        return "🐃";
    }
}
