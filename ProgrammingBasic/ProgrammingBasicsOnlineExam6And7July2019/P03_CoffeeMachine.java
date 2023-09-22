package ProgrammingBasicsOnlineExam6And7July2019;

import java.util.Scanner;

public class P03_CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drinkType = scanner.nextLine();
        String sugar = scanner.nextLine();
        int drinksCount = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;

        if (drinkType.equals("Espresso")) {
            if (sugar.equals("Without")) {
                totalPrice += 0.90;
            } else if (sugar.equals("Normal")) {
                totalPrice += 1;
            } else if (sugar.equals("Extra")) {
                totalPrice += 1.20;
            }
        } else if (drinkType.equals("Cappuccino")) {
            if (sugar.equals("Without")) {
                totalPrice += 1;
            } else if (sugar.equals("Normal")) {
                totalPrice += 1.20;
            } else if (sugar.equals("Extra")) {
                totalPrice += 1.60;
            }
        } else if (drinkType.equals("Tea")) {
            if (sugar.equals("Without")) {
                totalPrice += 0.50;
            } else if (sugar.equals("Normal")) {
                totalPrice += 0.60;
            } else if (sugar.equals("Extra")) {
                totalPrice += 0.70;
            }
        }

        totalPrice *= drinksCount;

        if (sugar.equals("Without")) {
            totalPrice *= 0.65;
        }
        if (drinkType.equals("Espresso") && drinksCount >= 5) {
            totalPrice *= 0.75;
        }
        if (totalPrice > 15) {
            totalPrice *= 0.80;
        }


        System.out.printf("You bought %d cups of %s for %.2f lv.", drinksCount, drinkType, totalPrice);
    }
}
