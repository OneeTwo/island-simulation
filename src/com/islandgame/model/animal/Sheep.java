package com.islandgame.model.animal;

import com.islandgame.model.Herbivore;

public class Sheep extends Herbivore {
    private static final double WEIGHT = 70;
    private static final int SPEED = 3;
    private static final double FOOD = 15;
    private static final int MAX = 140;

    public Sheep() {
        super(WEIGHT, SPEED, FOOD, MAX);
    }

    @Override
    public String getSymbol() {
        return "🐐";
    }

}
