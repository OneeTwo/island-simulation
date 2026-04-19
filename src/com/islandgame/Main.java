package com.islandgame;

import com.islandgame.model.animal.Rabbit;
import com.islandgame.model.animal.Wolf;
import com.islandgame.world.Island;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = readPositiveInt(scanner, "Enter island width (>0): ");
        int height = readPositiveInt(scanner, "Enter island height (>0): ");

        Island island = new Island(width, height);
        Random random = new Random();

        // started init
        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);

            if (random.nextBoolean()) {
                island.addAnimal(x, y, new Wolf());
            } else {
                island.addAnimal(x, y, new Rabbit());
            }
        }

        System.out.println("=== START ===");
        island.printIslandPretty();
        island.printStatistics();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> {

            System.out.println("\n=== NEW STEP ===");

            island.growPlants();
            //multithreading
            island.moveAnimalsParallel();

            island.processEatingParallel();
            island.processPlantEatingParallel();
            island.removeStarvingAnimalsParallel();
            island.reproduceAnimals();
            //results
            island.printIslandPretty();
            island.printStatistics();

            if (island.getTotalAnimals() == 0) {
                System.out.println("ALL ANIMALS DEAD");
                scheduler.shutdown();
                island.shutdown();
            }

        }, 0, 1, TimeUnit.SECONDS);
    }

    private static int readPositiveInt(Scanner scanner, String message) {
        int value;

        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                value = scanner.nextInt();

                if (value > 0) {
                    return value;
                }
            } else {
                scanner.next();
            }

            System.out.println("Invalid input. Enter number > 0.");
        }
    }
}