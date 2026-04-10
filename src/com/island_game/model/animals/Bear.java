package com.island_game.model.animals;

import com.island_game.model.Predator;

public class Bear extends Predator {
    public Bear() {
        super(300, 2, 80, 5);

        foodMap.put(Rabbit.class, 80);
        foodMap.put(Deer.class, 80);
        foodMap.put(Goat.class, 70);
        foodMap.put(Sheep.class, 70);
        foodMap.put(Boar.class, 50);
    }

    @Override
    public String getSymbol() {
        return "🐻";
    }
}
