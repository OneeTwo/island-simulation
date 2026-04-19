package com.islandgame.model.animal;

import com.islandgame.model.Herbivore;

public class Boar extends Herbivore {
    private static final double WEIGHT = 400;
    private static final int SPEED = 2;
    private static final double FOOD = 50;
    private static final int MAX = 50;

    public Boar() {
        super(WEIGHT, SPEED, FOOD, MAX);
    }

    @Override
    public String getSymbol() {
        return "🐗";
    }
}
