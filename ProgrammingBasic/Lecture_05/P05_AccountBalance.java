package Lecture_05;

import java.util.Scanner;

public class P05_AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sum = 0;

        while (!input.equals("NoMoreMoney")) {
            double number = Double.parseDouble(input);
            if (number < 0) {
                System.out.printf("Invalid operation!%n");
                break;
            }
                System.out.printf("Increase: %.2f%n", number);
                sum += number;

            input = scanner.nextLine();
        }

        System.out.printf("Total: %.2f", sum);
    }
}
