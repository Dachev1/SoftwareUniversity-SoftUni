package ProgrammingBasicsOnlineExam6And7April2019;

import java.util.Scanner;

public class P02_GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double filmBudget = Double.parseDouble(scanner.nextLine());
        int extrasCount = Integer.parseInt(scanner.nextLine());
        double pricePerOutfit = Double.parseDouble(scanner.nextLine());

        if (extrasCount > 150) {
            pricePerOutfit *= 0.90;
        }

        double total = (filmBudget * 0.10) + extrasCount * pricePerOutfit;
        double diff = Math.abs(filmBudget - total);

        if (filmBudget >= total) {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", diff);
        } else {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", diff);
        }
    }
}
