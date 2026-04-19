package com.islandgame.world;

import com.islandgame.model.Animal;
import com.islandgame.settings.MoveAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Island {

    private final Location[][] locations;
    private final int width;
    private final int height;

    private final ExecutorService executor =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public Island(int width, int height) {
        this.width = width;
        this.height = height;

        locations = new Location[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations[x][y] = new Location();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    public void moveAnimalsParallel() {
        List<Future<List<MoveAction>>> futures = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int finalX = x;
                int finalY = y;

                futures.add(executor.submit(() ->
                        locations[finalX][finalY].prepareMoves(finalX, finalY, this)
                ));
            }
        }

        for (Future<List<MoveAction>> future : futures) {
            try {
                applyMoves(future.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Move task interrupted", e);
            } catch (ExecutionException e) {
                throw new RuntimeException("Move task failed", e);
            }
        }
    }

    private void applyMoves(List<MoveAction> moves) {
        for (MoveAction move : moves) {
            Location from = locations[move.fromX][move.fromY];
            Location to = locations[move.toX][move.toY];

            synchronized (from) {
                if (from.removeAnimal(move.animal)) {
                    synchronized (to) {
                        to.addAnimal(move.animal);
                    }
                }
            }
        }
    }

    public void processEatingParallel() {
        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                int x = i;
                int y = j;
                tasks.add(() -> locations[x][y].processEating());
            }
        }

        runTasks(tasks);
    }

    public void processPlantEatingParallel() {
        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                int x = i;
                int y = j;
                tasks.add(() -> locations[x][y].processPlantEating());
            }
        }

        runTasks(tasks);
    }

    public void removeStarvingAnimalsParallel() {
        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                int x = i;
                int y = j;
                tasks.add(() -> locations[x][y].removeStarvingAnimals());
            }
        }

        runTasks(tasks);
    }

    public void reproduceAnimals() {
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j].reproduce();
            }
        }
    }

    private void runTasks(List<Runnable> tasks) {
        List<Future<?>> futures = new ArrayList<>();

        for (Runnable task : tasks) {
            futures.add(executor.submit(task));
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Task interrupted", e);
            } catch (ExecutionException e) {
                throw new RuntimeException("Task failed", e);
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

    public int getTotalAnimals() {
        int total = 0;

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                total += locations[i][j].getAnimals().size();
            }
        }

        return total;
    }

    public void shutdown() {
        executor.shutdown();
    }
}