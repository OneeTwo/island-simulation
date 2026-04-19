package com.islandgame.model.animals;

import com.islandgame.model.Herbivore;

public class Deer extends Herbivore {
    private static final double WEIGHT = 300;
    private static final int SPEED = 4;
    private static final double FOOD = 50;
    private static final int MAX = 20;

    public Deer() {
        super(WEIGHT, SPEED, FOOD, MAX);
    }

    @Override
    public String getSymbol() {
        return "🦌";
    }
}