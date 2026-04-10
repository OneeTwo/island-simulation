package com.island_game;

import com.island_game.config.Settings;
import com.island_game.model.animals.Rabbit;
import com.island_game.model.animals.Wolf;
import com.island_game.world.Island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Island island = new Island(Settings.WIDTH, Settings.HEIGHT);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        // 🔥 початкове заповнення
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

        // ⚡ симуляція кожну секунду
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {

            System.out.println("\n=== NEW STEP ===");

            if (island.getTotalAnimals() == 0) {
                System.out.println("ALL ANIMALS DEAD 💀");
                scheduler.shutdown();
            }

            // 🌿 рослини
            island.growPlants();

            // 🧵 паралельні дії
            island.moveAnimalsBetweenCells();
            island.processEatingParallel();
            island.processPlantEatingParallel();
            island.removeStarvingAnimalsParallel();
            island.reproduceAnimals();

            // 📊 вивід
            island.printIslandPretty();
            island.printStatistics();

        }, 0, Settings.STEP_DELAY, TimeUnit.MILLISECONDS);
    }
}