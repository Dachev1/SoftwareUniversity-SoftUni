package Exercise_September_15;

import java.util.Scanner;

public class P07_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double totalCoins = 0;
        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                totalCoins += coin;
            } else {
                System.out.printf("Cannot accept %.2f\n", coin);
            }
            input = scanner.nextLine();
        }

        String products = scanner.nextLine();
        while (!products.equals("End")) {
            if (products.equals("Nuts")) {
                if (totalCoins >= 2) {
                    totalCoins -= 2;
                    System.out.printf("Purchased %s\n", products);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (products.equals("Water")) {
                if (totalCoins >= 0.7) {
                    totalCoins -= 0.7;
                    System.out.printf("Purchased %s\n", products);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (products.equals("Crisps")) {
                if (totalCoins >= 1.5) {
                    totalCoins -= 1.5;
                    System.out.printf("Purchased %s\n", products);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (products.equals("Soda")) {
                if (totalCoins >= 0.8) {
                    totalCoins -= 0.8;
                    System.out.printf("Purchased %s\n", products);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (products.equals("Coke")) {
                if (totalCoins >= 1) {
                    totalCoins -= 1;
                    System.out.printf("Purchased %s\n", products);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else {
                System.out.println("Invalid product");
            }

            products = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", totalCoins);
    }
}
