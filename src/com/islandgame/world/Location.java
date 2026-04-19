package com.islandgame.world;

import com.islandgame.model.Animal;
import com.islandgame.model.Herbivore;
import com.islandgame.model.Predator;

import java.util.*;

public class Location {

    private final List<Animal> animals = new ArrayList<>();
    private int plants = 0;

    public synchronized boolean addAnimal(Animal animal) {

        long count = animals.stream()
                .filter(a -> a.getClass() == animal.getClass())
                .count();

        if (count < animal.getMaxInCell()) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public void growPlants() {
        plants = Math.min(plants + 2, 50);
    }

    public synchronized void processEating() {

        Random random = new Random();
        Iterator<Animal> iterator = animals.iterator();

        while (iterator.hasNext()) {
            Animal prey = iterator.next();

            if (prey instanceof Herbivore) {

                for (Animal hunter : animals) {

                    if (hunter instanceof Predator predator) {

                        int chance = predator.getEatChance(prey.getClass());

                        if (chance > 0 && random.nextInt(100) < chance) {
                            iterator.remove();
                            predator.setHasEaten(true);
                            predator.resetStarvation();
                            break;
                        }
                    }
                }
            }
        }
    }

    public synchronized void processPlantEating() {

        for (Animal animal : animals) {

            if (animal instanceof Herbivore && plants > 0) {
                plants--;
                animal.setHasEaten(true);
                animal.resetStarvation();
            }
        }
    }

    public synchronized void removeStarvingAnimals() {

        Iterator<Animal> iterator = animals.iterator();

        while (iterator.hasNext()) {
            Animal animal = iterator.next();

            if (!animal.hasEaten()) {
                animal.increaseStarvation();
            }

            if (animal.getStarvation() >= 5) {
                iterator.remove();
            } else {
                animal.setHasEaten(false);
            }
        }
    }

    public synchronized void reproduce() {

        Map<Class<? extends Animal>, Integer> countMap = new HashMap<>();

        for (Animal animal : animals) {
            Class<? extends Animal> type = animal.getClass();
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        List<Animal> newborns = new ArrayList<>();

        for (var entry : countMap.entrySet()) {

            if (entry.getValue() >= 2) {
                try {
                    Animal newAnimal = entry.getKey().getDeclaredConstructor().newInstance();
                    newborns.add(newAnimal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (Animal animal : newborns) {
            addAnimal(animal);
        }
    }

    public synchronized void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
}