package ProgrammingFundamentals.DataTypesAndVariables.Lab;

import java.util.Scanner;

public class P10_SpecialNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            int number = i;
            int sumOfDigits = 0;

            while (number > 0) {
                int LastDigit = number % 10;

                sumOfDigits += LastDigit;

                number /= 10;
            }

            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                System.out.printf("%d -> True\n", i);
            } else {
                System.out.printf("%d -> False\n", i);
            }
        }
    }
}
