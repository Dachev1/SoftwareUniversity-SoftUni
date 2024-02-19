package ExamPreparation.October_23_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class AutumnCocktails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> bucketsOfIngredients = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(bucketsOfIngredients::offer);

        Deque<Integer> freshnessLevels = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(freshnessLevels::push);

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        while (!bucketsOfIngredients.isEmpty() && !freshnessLevels.isEmpty()) {
            int ingredient = bucketsOfIngredients.poll();
            int freshness = freshnessLevels.pop();

            if (ingredient == 0) {
                freshnessLevels.addFirst(freshness);
                continue;
            }

            int multiplication = ingredient * freshness;

            if (multiplication == 150) {
                pearSour++;
            } else if (multiplication == 250) {
                theHarvest++;
            } else if (multiplication == 300) {
                appleHinny++;
            } else if (multiplication == 400) {
                highFashion++;
            } else {
                bucketsOfIngredients.offer(ingredient + 5);
            }
        }

        if (pearSour > 0 && theHarvest > 0 && appleHinny > 0 && highFashion > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!bucketsOfIngredients.isEmpty()) {
            int sum = 0;

            while (!bucketsOfIngredients.isEmpty()) {
                sum += bucketsOfIngredients.poll();
            }

            System.out.println("Ingredients left: " + sum);
        }

        if (appleHinny > 0) {
            System.out.printf(" # Apple Hinny --> %d\n", appleHinny);
        }

        if (highFashion > 0) {
            System.out.printf(" # High Fashion --> %d\n", highFashion);
        }

        if (pearSour > 0) {
            System.out.printf(" # Pear Sour --> %d\n", pearSour);
        }

        if (theHarvest > 0) {
            System.out.printf(" # The Harvest --> %d\n", theHarvest);
        }
    }
}
