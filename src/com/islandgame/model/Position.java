package com.islandgame.model;

import java.util.Objects;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position move(int dx, int dy) {
        return new Position(
                x + dx,
                y + dy
        );
    }

    public boolean isInside(
            int width,
            int height
    ) {
        return x >= 0 &&
                x < width &&
                y >= 0 &&
                y < height;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (!(o instanceof Position))
            return false;

        Position position = (Position) o;

        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}