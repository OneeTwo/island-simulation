package com.islandgame.model;

public abstract class Animal {
    protected double weight;
    protected int speed;
    protected double foodNeeded;
    protected int maxInCell;
    protected boolean hasEaten = false;
    protected int starvation = 0;

    public Animal(double weight, int speed, double foodNeeded, int maxInCell) {
        this.weight = weight;
        this.speed = speed;
        this.foodNeeded = foodNeeded;
        this.maxInCell = maxInCell;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxInCell() {
        return maxInCell;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }

    public boolean hasEaten() {
        return hasEaten;
    }

    public abstract String getSymbol();

    public void increaseStarvation() {
        starvation++;
    }

    public void resetStarvation() {
        starvation = 0;
    }

    public int getStarvation() {
        return starvation;
    }
}