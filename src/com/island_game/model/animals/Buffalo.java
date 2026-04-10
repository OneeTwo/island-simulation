package com.island_game.model.animals;

import com.island_game.model.Herbivore;

public class Buffalo extends Herbivore {
    public Buffalo() {
        super(700, 3, 100, 10);
    }

    @Override
    public String getSymbol() {
        return "🐃";
    }
}
