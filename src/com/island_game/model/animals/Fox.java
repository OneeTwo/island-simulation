package com.island_game.model.animals;

import com.island_game.model.Predator;

public class Fox extends Predator {
    public Fox() {
        super(8, 2, 2, 30);

        foodMap.put(Rabbit.class, 70);
        foodMap.put(Mouse.class, 90);
        foodMap.put(Duck.class, 60);
    }

    @Override
    public String getSymbol() {
        return "🦊";
    }
}
