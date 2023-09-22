package MoreExercises_03;

import java.util.Scanner;

public class P04_CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String classType = "";
        String carType = "";
        double price = 0;

        if (budget <= 100) {
            classType = "Economy class";
            if (season.equals("Summer")) {
                carType = "Cabrio";
                price = budget * 0.35;
            } else {
                carType = "Jeep";
                price = budget * 0.65;
            }
        } else if (budget <= 500) {
            classType = "Compact class";
            if (season.equals("Summer")) {
                carType = "Cabrio";
                price = budget * 0.45;
            } else {
                carType = "Jeep";
                price = budget * 0.80;
            }
        } else if (budget > 500) {
            carType = "Jeep";
            classType = "Luxury class";
            price = budget * 0.90;
        }

        System.out.printf("%s%n", classType);
        System.out.printf("%s - %.2f", carType, price);
    }
}
