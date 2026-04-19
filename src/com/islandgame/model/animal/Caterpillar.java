package com.islandgame.model.animal;

import com.islandgame.model.Herbivore;

public class Caterpillar extends Herbivore {
    private static final double WEIGHT = 0.01;
    private static final int SPEED = 0;
    private static final double FOOD = 0;
    private static final int MAX = 1000;

    public Caterpillar() {
        super(WEIGHT, SPEED, FOOD, MAX);
    }

    @Override
    public String getSymbol() {
        return "🐛";
    }
}
