package MoreExercises_03;

import java.util.Scanner;

public class P06_TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double km = Double.parseDouble(scanner.nextLine());

        double priceKm = 0;

        if (km <= 5000) {
            if (season.equals("Spring") || season.equals("Autumn")) {
                priceKm = 0.75;
            } else if (season.equals("Summer")) {
                priceKm = 0.90;
            } else if (season.equals("Winter")) {
                priceKm = 1.05;
            }
        } else if (km <= 10000) {
            if (season.equals("Spring") || season.equals("Autumn")) {
                priceKm = 0.95;
            } else if (season.equals("Summer")) {
                priceKm = 1.10;
            } else if (season.equals("Winter")) {
                priceKm = 1.25;
            }
        } else {
            priceKm = 1.45;
        }

        double total = ((km * priceKm) * 4) * 0.9;
        System.out.printf("%.2f", total);
    }
}
