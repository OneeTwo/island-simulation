package com.islandgame.model.animals;

import com.islandgame.model.Herbivore;

public class Rabbit extends Herbivore {
    private static final double WEIGHT = 2;
    private static final int SPEED = 2;
    private static final double FOOD = 0.45;
    private static final int MAX = 150;

    public Rabbit() {
        super(WEIGHT, SPEED, FOOD, MAX);
    }

    @Override
    public String getSymbol() {
        return "🐰";
    }
}
