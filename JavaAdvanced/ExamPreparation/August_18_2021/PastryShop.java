package ExamPreparation.August_18_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PastryShop {

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

        int biscuit = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            int sum = liquid + ingredient;

            if (sum == 25) {
                biscuit++;
            } else if (sum == 50) {
                cake++;
            } else if (sum == 75) {
                pastry++;
            } else if (sum == 100) {
                pie++;
            } else {
                ingredients.push(ingredient + 3);
            }
        }

        if (biscuit > 0 && cake > 0 && pastry > 0 && pie > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (!liquids.isEmpty()) {
            System.out.println("Liquids left: " + liquids.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Liquids left: none");
        }

        if (!ingredients.isEmpty()) {
            System.out.println("Ingredients left: " + ingredients.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Ingredients left: none");
        }

        System.out.println("Biscuit: " + biscuit);
        System.out.println("Cake: " + cake);
        System.out.println("Pie: " + pie);
        System.out.println("Pastry: " + pastry);
    }
}
