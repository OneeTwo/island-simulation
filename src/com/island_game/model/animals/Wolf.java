package com.island_game.model.animals;

import java.util.HashMap;
import java.util.Map;
import com.island_game.model.Predator;

public class Wolf extends Predator {
    public Wolf() {
        super(50, 3, 8, 30);

        foodMap.put(Rabbit.class, 80);
        foodMap.put(Mouse.class, 60);
        foodMap.put(Deer.class, 15);
        foodMap.put(Goat.class, 20);
        foodMap.put(Sheep.class, 25);
    }

    @Override
    public String getSymbol() {
        return "🐺";
    }
}
