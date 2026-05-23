package com.islandgame.settings;

import com.islandgame.model.Animal;
import com.islandgame.model.Position;

public class MoveAction {

    public final Animal animal;

    public final Position from;
    public final Position to;

    public MoveAction(
            Animal animal,
            Position from,
            Position to
    ) {
        this.animal = animal;
        this.from = from;
        this.to = to;
    }
}