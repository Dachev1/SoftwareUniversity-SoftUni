package ProgrammingFundamentals.MidExamsPractise.Exam1;

import java.util.Scanner;

public class P01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceWithoutTax = 0;
        double priceMultiplayer = 1;
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("regular")) {
                break;
            }

            if (input.equals("special")) {
                priceMultiplayer = 0.9;
                break;
            }

            double currentPrice = Double.parseDouble(input);

            if (currentPrice < 0) {
                System.out.println("Invalid price!");
            } else {
                priceWithoutTax += currentPrice;
            }
        }

        double taxes = priceWithoutTax * 0.2;
        double totalPrice = (priceWithoutTax + taxes) * priceMultiplayer;

        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", priceWithoutTax);
            System.out.printf("Taxes: %.2f$\n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPrice);
        }
    }
}
