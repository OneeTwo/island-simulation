package com.island_game.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Predator extends Animal {
    protected Map<Class<? extends Animal>, Integer> foodMap = new HashMap<>();

    public Predator(double weight, int speed, double foodNeeded, int maxInCell) {
        super(weight, speed, foodNeeded, maxInCell);
    }

    public int getEatChance(Class<? extends Animal> preyClass) {
        return foodMap.getOrDefault(preyClass, 0);
    }
}
