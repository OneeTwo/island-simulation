package com.islandgame.model.animal;

import com.islandgame.model.Herbivore;

public class Goat extends Herbivore {
    private static final double WEIGHT = 60;
    private static final int SPEED = 3;
    private static final double FOOD = 10;
    private static final int MAX = 140;

    public Goat() {
        super(WEIGHT, SPEED, FOOD, MAX);
    }

    @Override
    public String getSymbol() {
        return "🐐";
    }
}
