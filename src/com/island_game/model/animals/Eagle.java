package com.island_game.model.animals;

import com.island_game.model.Predator;

public class Eagle extends Predator {
    public Eagle() {
        super(6, 3, 1, 20);

        foodMap.put(Rabbit.class, 90);
        foodMap.put(Mouse.class, 90);
        foodMap.put(Duck.class, 80);
    }

    @Override
    public String getSymbol() {
        return "🦅";
    }
}
