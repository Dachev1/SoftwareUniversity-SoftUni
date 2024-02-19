package ExamPreparation.April_13_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> steels = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(steels::offer);

        Deque<Integer> carbons = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(carbons::push);

        int gladius = 0;
        int shamshir = 0;
        int katana = 0;
        int sabre = 0;

        while (!steels.isEmpty() && !carbons.isEmpty()) {
            int steel = steels.poll();
            int carbon = carbons.pop();

            int sum = steel + carbon;

            if (sum == 70) {
                gladius++;
            } else if (sum == 80) {
                shamshir++;
            } else if (sum == 90) {
                katana++;
            } else if (sum == 110) {
                sabre++;
            } else {
                carbon += 5;
                carbons.push(carbon);
            }
        }

        int totalNumberOfSwords = gladius + shamshir + katana + sabre;

        if (totalNumberOfSwords > 0) {
            System.out.printf("You have forged %d swords.\n", totalNumberOfSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (!steels.isEmpty()) {
            System.out.printf("Steel left: %s\n", steels.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Steel left: none");
        }

        if (!carbons.isEmpty()) {
            System.out.printf("Carbon left: %s\n", carbons.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Carbon left: none");
        }

        if (gladius > 0) {
            System.out.println("Gladius: " + gladius);
        }

        if (katana > 0) {
            System.out.println("Katana: " + katana);
        }

        if (sabre > 0) {
            System.out.println("Sabre: " + sabre);
        }

        if (shamshir > 0) {
            System.out.println("Shamshir: " + shamshir);
        }
    }
}
