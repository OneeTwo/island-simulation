package com.island_game.model.animals;

import com.island_game.model.Predator;

public class Snake extends Predator {
    public Snake() {
        super(15, 1, 3, 30);

        foodMap.put(Mouse.class, 80);
        foodMap.put(Rabbit.class, 20);
    }

    @Override
    public String getSymbol() {
        return "🐍";
    }
}
