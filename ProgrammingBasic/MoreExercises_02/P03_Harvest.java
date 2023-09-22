package MoreExercises_02;

import java.util.Scanner;

public class P03_Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int harvestArea = Integer.parseInt(scanner.nextLine());
        double wineArea = Double.parseDouble(scanner.nextLine());
        int neededLiters = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double totalGrapes = harvestArea * wineArea;
        double wine = 0.4 * totalGrapes / 2.5;

        if (wine >= neededLiters) {
            double left = wine - neededLiters;
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(wine));
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(left), Math.ceil(left / workers));
        } else {
            double needed = neededLiters - wine;
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(needed));
        }
    }
}
