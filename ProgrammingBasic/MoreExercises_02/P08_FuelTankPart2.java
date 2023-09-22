package MoreExercises_02;

import java.util.Scanner;

public class P08_FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double amountOfFuel = Double.parseDouble(scanner.nextLine());
        String discountCard = scanner.nextLine();

        double price = 0;

        if ("Gasoline".equals(fuelType)) {
            if ("Yes".equals(discountCard)) {
                price = (2.22 - 0.18) * amountOfFuel;
            } else {
                price = 2.22 * amountOfFuel;
            }
        } else if ("Diesel".equals(fuelType)) {
            if ("Yes".equals(discountCard)) {
                price = (2.33 - 0.12) * amountOfFuel;
            } else {
                price = 2.33 * amountOfFuel;
            }
        } else if ("Gas".equals(fuelType)) {
            if ("Yes".equals(discountCard)) {
                price = (0.93 - 0.08) * amountOfFuel;
            } else {
                price = 0.93 * amountOfFuel;
            }
        } else {
            System.out.println("Invalid fuel!");
        }

        if (amountOfFuel >= 20 && amountOfFuel <= 25) {
            price *= 0.92;
        } else if (amountOfFuel > 25) {
            price *= 0.90;
        }

        System.out.printf("%.2f lv.", price);
    }
}
