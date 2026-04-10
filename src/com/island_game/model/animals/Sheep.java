package com.island_game.model.animals;

import com.island_game.model.Herbivore;

public class Sheep extends Herbivore {
    public Sheep() {
        super(70, 3, 15, 140);
    }

    @Override
    public String getSymbol() {
        return "🐐";
    }

}
