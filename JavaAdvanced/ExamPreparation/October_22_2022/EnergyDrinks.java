package ExamPreparation.October_22_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EnergyDrinks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> milligramsOfCaffeinе = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(milligramsOfCaffeinе::push);

        Deque<Integer> energyDrinks = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(energyDrinks::offer);

        int caffeineTaken = 0; // max is 300

        while (!milligramsOfCaffeinе.isEmpty() && !energyDrinks.isEmpty()) {
            int milligrams = milligramsOfCaffeinе.pop();
            int drink = energyDrinks.poll();

            int sum = milligrams * drink;

            int temp = caffeineTaken + sum;

            if (temp <= 300) {
                caffeineTaken = temp;
            } else {
                energyDrinks.offer(drink);
                caffeineTaken -= 30;

                if (caffeineTaken < 0) {
                    caffeineTaken = 0;
                }
            }
        }

        if (!energyDrinks.isEmpty()) {
            System.out.println("Drinks left: " + energyDrinks.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.\n", caffeineTaken);
    }
}

