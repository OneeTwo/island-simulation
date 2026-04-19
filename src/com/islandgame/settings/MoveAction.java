package com.islandgame.settings;

import com.islandgame.model.Animal;

public class MoveAction {
        public final Animal animal;
        public final int fromX, fromY;
        public final int toX, toY;

        public MoveAction(Animal animal, int fromX, int fromY, int toX, int toY) {
            this.animal = animal;
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }
}
