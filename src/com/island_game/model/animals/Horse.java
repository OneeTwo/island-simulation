package com.island_game.model.animals;

import com.island_game.model.Herbivore;

public class Horse extends Herbivore {
    public Horse() {
        super(400, 4, 60, 20);
    }

    @Override
    public String getSymbol() {
        return "🐎";
    }
}
