package ProgrammingFundamentals.Methods.Lab;

import java.util.Scanner;

public class P05_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println(String.format("%.2f",priceCalculator(product, quantity)));
    }

    public static double priceCalculator(String product, int quantity) {
        double total = 0;
        if (product.equals("coffee")) {
            total = quantity * 1.50;
        } else  if (product.equals("water")) {
            total = quantity * 1.00;
        }else  if (product.equals("coke")) {
            total = quantity * 1.40;
        } else  if (product.equals("snacks")) {
            total = quantity * 2.00;
        }

        return total;
    }
}
