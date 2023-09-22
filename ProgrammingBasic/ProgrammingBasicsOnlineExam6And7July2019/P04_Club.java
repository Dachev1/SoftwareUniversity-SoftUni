package ProgrammingBasicsOnlineExam6And7July2019;

import java.util.Scanner;

public class P04_Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double target = Double.parseDouble(scanner.nextLine());
        String cocktail = scanner.nextLine();
        double income = 0.0;

        while (!"Party!".equals(cocktail)) {
            int quantity = Integer.parseInt(scanner.nextLine());

            int price = quantity * cocktail.length();
            double finalPrice = price;
            if (price % 2 != 0) {
                finalPrice *= 0.75;
            }
            income += finalPrice;
            target -= finalPrice;
            if (target <= 0) {
                break;
            }

            cocktail = scanner.nextLine();
        }

        if ("Party!".equals(cocktail)) {
            System.out.println(String.format("We need %.2f leva more.", target));
        } else {
            System.out.println("Target acquired.");
        }

        System.out.println(String.format("Club income - %.2f leva.", income));
    }
}
