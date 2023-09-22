package Lecture_02.LectureEXC_02;

import java.util.Scanner;

public class GodzillaVsKong_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double filmBudget = Double.parseDouble(scanner.nextLine());
        int extrasCount = Integer.parseInt(scanner.nextLine());
        double pricePerOneOutfit = Double.parseDouble(scanner.nextLine());

        if (extrasCount > 150) {
            pricePerOneOutfit *= 0.9;
        }

        double decorPrice = filmBudget * 0.1;
        double outfitPrice = extrasCount * pricePerOneOutfit;

        double finalPrice = decorPrice + outfitPrice;
        double diff = Math.abs(filmBudget - finalPrice);

        if (finalPrice <= filmBudget) {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", diff);
        } else {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", diff);
        }
    }
}
