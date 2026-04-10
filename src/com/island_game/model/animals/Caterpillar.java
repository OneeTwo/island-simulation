package com.island_game.model.animals;

import com.island_game.model.Herbivore;

public class Caterpillar extends Herbivore {
    public Caterpillar() {
        super(0.01, 0, 0.005, 1000);
    }

    @Override
    public String getSymbol() {
        return "🐛";
    }
}
