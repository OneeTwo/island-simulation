package com.island_game.model.animals;

import com.island_game.model.Herbivore;

public class Deer extends Herbivore {
    public Deer() {
        super(300, 4, 50, 20);
    }

    @Override
    public String getSymbol() {
        return "🦌";
    }
}