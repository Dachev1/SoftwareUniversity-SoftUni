package Lecture_03;

import java.util.Scanner;

public class FruitShop_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0;
        switch (dayOfWeek) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                if ("banana".equals(product)) {
                    price = 2.50;
                } else if ("apple".equals(product)) {
                    price = 1.20;
                } else if ("orange".equals(product)) {
                    price = 0.85;
                } else if ("grapefruit".equals(product)) {
                    price = 1.45;
                } else if ("kiwi".equals(product)) {
                    price = 2.70;
                } else if ("pineapple".equals(product)) {
                    price = 5.50;
                } else if ("grapes".equals(product)) {
                    price = 3.85;
                }
                break;
            case "Saturday":
            case "Sunday":
                if ("banana".equals(product)) {
                    price = 2.70;
                } else if ("apple".equals(product)) {
                    price = 1.25;
                } else if ("orange".equals(product)) {
                    price = 0.90;
                } else if ("grapefruit".equals(product)) {
                    price = 1.60;
                } else if ("kiwi".equals(product)) {
                    price = 3;
                } else if ("pineapple".equals(product)) {
                    price = 5.60;
                } else if ("grapes".equals(product)) {
                    price = 4.20;
                }
                break;
        }

        if (price == 0) {
            System.out.println("error");
        } else {
            System.out.printf("%.2f", price * quantity);
        }
    }
}
