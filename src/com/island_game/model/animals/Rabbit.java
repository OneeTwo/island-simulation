package com.island_game.model.animals;

import com.island_game.model.Herbivore;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super(2, 2, 0.45, 150);
    }

    @Override
    public String getSymbol() {
        return "🐰";
    }
}
