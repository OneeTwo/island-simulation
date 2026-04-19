package com.islandgame.world;

import com.islandgame.model.Animal;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Island {

    private final Location[][] locations;

    private final ExecutorService executor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public Island(int width, int height) {
        locations = new Location[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    public void addAnimal(int x, int y, Animal animal) {
        locations[x][y].addAnimal(animal);
    }

    public void growPlants() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j].growPlants();
            }
        }
    }


    public void processEatingParallel() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {

                int x = i;
                int y = j;

                executor.submit(() -> locations[x][y].processEating());
            }
        }
    }

    public void processPlantEatingParallel() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {

                int x = i;
                int y = j;

                executor.submit(() -> locations[x][y].processPlantEating());
            }
        }
    }

    public void removeStarvingAnimalsParallel() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {

                int x = i;
                int y = j;

                executor.submit(() -> locations[x][y].removeStarvingAnimals());
            }
        }
    }

    public void reproduceAnimals() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j].reproduce();
            }
        }
    }

    public void printStatistics() {

        Map<String, Integer> stats = new HashMap<>();

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {

                for (Animal animal : locations[i][j].getAnimals()) {

                    String name = animal.getClass().getSimpleName();

                    stats.put(name, stats.getOrDefault(name, 0) + 1);
                }
            }
        }

        System.out.println("\n--- STATISTICS ---");

        int total = 0;

        for (var entry : stats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            total += entry.getValue();
        }

        System.out.println("Total animals: " + total);
    }

    public void printIslandPretty() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {

                var animals = locations[i][j].getAnimals();

                if (animals.isEmpty()) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + animals.get(0).getSymbol() + "x" + animals.size() + "]");
                }
            }
            System.out.println();
        }
    }

    public void moveAnimalsBetweenCells() {

        Random random = new Random();

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {

                Location current = locations[i][j];

                List<Animal> copy = new ArrayList<>(current.getAnimals());

                for (Animal animal : copy) {

                    int dx = random.nextInt(3) - 1;
                    int dy = random.nextInt(3) - 1;

                    int step = random.nextInt(animal.getSpeed() + 1);

                    int newX = i + dx * step;
                    int newY = j + dy * step;

                    if (newX >= 0 && newX < locations.length &&
                            newY >= 0 && newY < locations[i].length) {

                        Location target = locations[newX][newY];

                        if (target.addAnimal(animal)) {
                            current.removeAnimal(animal);;
                        }
                    }
                }
            }
        }
    }

    public int getTotalAnimals() {
        int total = 0;

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                total += locations[i][j].getAnimals().size();
            }
        }

        return total;
    }
}