package com.island_game.model.animals;

import com.island_game.model.Herbivore;

public class Mouse extends Herbivore {
    public Mouse() {
        super(0.05, 1, 0.01, 500);
    }

    @Override
    public String getSymbol() {
        return "🐭";
    }
}
