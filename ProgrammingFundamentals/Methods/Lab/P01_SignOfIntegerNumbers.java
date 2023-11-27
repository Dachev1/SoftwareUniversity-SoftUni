package ProgrammingFundamentals.Methods.Lab;

import java.util.Scanner;

public class P01_SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        signOfNumber(number);
    }

    public static void signOfNumber (int number) {
        if (number == 0) {
            System.out.println("The number 0 is zero.");
        } else if (number > 0) {
            System.out.printf("The number %d is positive.%n", number);
        } else {
            System.out.printf("The number %d is negative.%n", number);
        }
    }
}
