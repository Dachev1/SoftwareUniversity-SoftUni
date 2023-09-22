package MoreExercises_03;

import java.util.Scanner;

public class P01_MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String categoryType = scanner.nextLine();
        int groupCount = Integer.parseInt(scanner.nextLine());

        double ticketPrice = 0;
        double groupDiscount = 0;
        if (categoryType.equals("VIP")) {
            ticketPrice = 499.99 * groupCount;
        } else if (categoryType.equals("Normal")) {
            ticketPrice = 249.99 * groupCount;
        }
        if (groupCount <= 4) {
            groupDiscount = 0.25;
        } else if (groupCount <= 9) {
            groupDiscount = 0.40;
        } else if (groupCount <= 24) {
            groupDiscount = 0.50;
        } else if (groupCount <= 49) {
            groupDiscount = 0.60;
        } else {
            groupDiscount = 0.75;
        }

        double priceWithDiscount = budget * groupDiscount;
        double diff = Math.abs(priceWithDiscount - ticketPrice);


        if (ticketPrice <= priceWithDiscount) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else  {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }

    }
}
