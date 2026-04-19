package com.islandgame;

import com.islandgame.config.Settings;
import com.islandgame.model.animals.Rabbit;
import com.islandgame.model.animals.Wolf;
import com.islandgame.world.Island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Island island = new Island(Settings.WIDTH, Settings.HEIGHT);
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(5);
            int y = random.nextInt(5);

            if (random.nextBoolean()) {
                island.addAnimal(x, y, new Wolf());
            } else {
                island.addAnimal(x, y, new Rabbit());
            }
        }

        System.out.println("=== START ===");
        island.printIslandPretty();
        island.printStatistics();


        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {

            System.out.println("\n=== NEW STEP ===");

            if (island.getTotalAnimals() == 0) {
                System.out.println("ALL ANIMALS DEAD");
                scheduler.shutdown();
            }

            island.growPlants();
            island.moveAnimalsBetweenCells();
            island.processEatingParallel();
            island.processPlantEatingParallel();
            island.removeStarvingAnimalsParallel();
            island.reproduceAnimals();

            island.printIslandPretty();
            island.printStatistics();

        }, 0, Settings.STEP_DELAY, TimeUnit.MILLISECONDS);
    }
}