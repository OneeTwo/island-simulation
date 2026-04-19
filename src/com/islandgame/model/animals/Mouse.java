package com.islandgame.model.animals;

import com.islandgame.model.Herbivore;

public class Mouse extends Herbivore {
    private static final double WEIGHT = 0.05;
    private static final int SPEED = 1;
    private static final double FOOD = 0.01;
    private static final int MAX = 500;

    public Mouse() {
        super(WEIGHT, SPEED, FOOD, MAX);
    }

    @Override
    public String getSymbol() {
        return "🐭";
    }
}
