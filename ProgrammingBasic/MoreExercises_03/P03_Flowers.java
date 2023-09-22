package MoreExercises_03;

import java.util.Scanner;

public class P03_Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countChrysanthemums = Integer.parseInt(scanner.nextLine());
        int countRoses = Integer.parseInt(scanner.nextLine());
        int countTulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String isHoliday = scanner.nextLine();

        double chrysanthemumsPrice = 0;
        double rosesPrice = 0;
        double tulipsPrice = 0;

        if (season.equals("Spring") || season.equals("Summer")) {
            chrysanthemumsPrice = 2 * countChrysanthemums;
            rosesPrice = 4.10 * countRoses;
            tulipsPrice = 2.50 * countTulips;

        } else if (season.equals("Autumn") || season.equals("Winter")) {
            chrysanthemumsPrice = 3.75 * countChrysanthemums;
            rosesPrice = 4.50 * countRoses;
            tulipsPrice = 4.15 * countTulips;
        }

        double totalPrice = chrysanthemumsPrice + rosesPrice + tulipsPrice;


        if (countTulips > 7 && season.equals("Spring")) {
            totalPrice *= 0.95;
        } else if (countRoses >= 10 && season.equals("Winter")) {
            totalPrice *= 0.90;
        }

        if (isHoliday.equals("Y")) {
            totalPrice *= 1.15;
        }

        int flowersCount = countChrysanthemums + countRoses + countTulips;
        if (flowersCount > 20) {
            totalPrice *= 0.80;
        }

        System.out.printf("%.2f", totalPrice + 2);
    }
}
