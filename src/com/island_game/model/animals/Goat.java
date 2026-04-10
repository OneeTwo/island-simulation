package com.island_game.model.animals;

import com.island_game.model.Herbivore;

public class Goat extends Herbivore {
    public Goat() {
        super(60, 3, 10, 140);
    }

    @Override
    public String getSymbol() {
        return "🐐";
    }
}
