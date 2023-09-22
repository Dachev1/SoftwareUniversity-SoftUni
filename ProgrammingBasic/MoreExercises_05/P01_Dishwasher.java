package MoreExercises_05;

import java.util.Scanner;

public class P01_Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int preparationCount = Integer.parseInt(scanner.nextLine());

        int totalPreparation = preparationCount * 750;
        String command = scanner.nextLine();
        int washedDishesCount = 0;
        int washedPotsCount = 0;
        int neededPreparation = 0;
        int days = 0;

        while (!command.equals("End")) {
            days++;
            if (days < 3) {
                int dishes = Integer.parseInt(command);
                neededPreparation += dishes * 5;
                washedDishesCount += dishes;
            } else {
                int pots = Integer.parseInt(command);
                neededPreparation += pots * 15;
                washedPotsCount += pots;
                days = 0;
            }

            if (neededPreparation > totalPreparation) {
                break;
            }

            command = scanner.nextLine();
        }

        if (command.equals("End")) {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", washedDishesCount, washedPotsCount);
            System.out.printf("Leftover detergent %d ml.", Math.abs(totalPreparation - neededPreparation));
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(neededPreparation - totalPreparation));
        }
    }
}
