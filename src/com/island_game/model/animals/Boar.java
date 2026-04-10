package com.island_game.model.animals;

import com.island_game.model.Herbivore;

public class Boar extends Herbivore {
    public Boar() {
        super(400, 2, 50, 50);
    }

    @Override
    public String getSymbol() {
        return "🐗";
    }
}
