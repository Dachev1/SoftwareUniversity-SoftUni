package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P10_TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            topNumberFinder(i);
        }
    }

    public static void topNumberFinder(int number) {
        int startNum = number;
        boolean oddDigit = false;
        boolean isDivisibleBy8 = false;
        int sumOfDigits = 0;

        while (number > 0) {
            int currentLastDigit = number % 10;
            sumOfDigits += currentLastDigit;

            if (currentLastDigit % 2 != 0) {
                oddDigit = true;
            }

            number /= 10;
        }

        if (sumOfDigits % 8 == 0) {
            isDivisibleBy8 = true;
        }

        if (oddDigit && isDivisibleBy8) {
            System.out.println(startNum);
        }
    }
}
