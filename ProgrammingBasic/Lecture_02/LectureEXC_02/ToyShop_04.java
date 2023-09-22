package Lecture_02.LectureEXC_02;

import java.util.Scanner;

public class ToyShop_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int countPuzzles = Integer.parseInt(scanner.nextLine());
        int countDolls = Integer.parseInt(scanner.nextLine());
        int countBears = Integer.parseInt(scanner.nextLine());
        int countMinions = Integer.parseInt(scanner.nextLine());
        int countTrucks = Integer.parseInt(scanner.nextLine());

        int toysCount = countPuzzles + countDolls + countBears + countMinions + countTrucks;
        double totalSum = countPuzzles * 2.60 + countDolls * 3 + countBears * 4.10 + countMinions * 8.20 + countTrucks * 2;

        if (toysCount >= 50) {
            totalSum = totalSum * 0.75;
        }

        totalSum = totalSum * 0.9;
        double diff = Math.abs(totalSum - tripPrice);

        if(totalSum >= tripPrice) {
            System.out.printf("Yes! %.2f lv left.", diff);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.",  diff);
        }
    }
}
