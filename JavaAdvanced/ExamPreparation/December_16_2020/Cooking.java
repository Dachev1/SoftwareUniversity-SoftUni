package ExamPreparation.December_16_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Cooking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liquids = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(liquids::offer);

        Deque<Integer> ingredients = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push);

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            int sum = liquid + ingredient;

            if (sum == 25) {
                bread++;
            } else if (sum == 50) {
                cake++;
            } else if (sum == 75) {
                pastry++;
            } else if (sum == 100) {
                fruitPie++;
            } else {
                ingredients.push(ingredient + 3);
            }
        }

        if (bread > 0 && cake > 0 && pastry > 0 && fruitPie > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquids.toString().toString().replaceAll("[\\[\\]]", ""));
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredients.toString().toString().replaceAll("[\\[\\]]", ""));
        }

        if (bread >= 0) {
            System.out.println("Bread: " + bread);
        }

        if (cake >= 0) {
            System.out.println("Cake: " + cake);
        }

        if (fruitPie >= 0) {
            System.out.println("Fruit Pie: " + fruitPie);
        }

        if (pastry >= 0) {
            System.out.println("Pastry: " + pastry);
        }
    }
}
