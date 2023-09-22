package Lecture_03.LectureEXC_03;

import java.util.Scanner;

public class P03_NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowersType = scanner.nextLine();
        int flowersCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0;
        switch (flowersType) {
            case "Roses":
                price = 5 * flowersCount;
                if (flowersCount > 80) {
                    price = price * 0.9;
                }
                break;
            case "Dahlias":
                price = 3.80 * flowersCount;
                if (flowersCount > 90) {
                    price = price * 0.85;
                }
                break;
            case "Tulips":
                price = 2.80 * flowersCount;
                if (flowersCount > 80) {
                    price = price * 0.85;
                }
                break;
            case "Narcissus":
                price = 3 * flowersCount;
                if (flowersCount < 120) {
                    price = price * 1.15;
                }
                break;
            case "Gladiolus":
                price = 2.50 * flowersCount;
                if (flowersCount < 80) {
                    price = price * 1.20;
                }
                break;
        }

        double diff = Math.abs(budget - price);
        if (budget >= price) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount, flowersType, diff);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", diff);
        }
    }
}
