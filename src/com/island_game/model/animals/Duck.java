package com.island_game.model.animals;

import com.island_game.model.Herbivore;

public class Duck extends Herbivore {
    public Duck() {
        super(1, 2, 0.15, 200);
    }

    @Override
    public String getSymbol() {
        return "🦆";
    }
}
