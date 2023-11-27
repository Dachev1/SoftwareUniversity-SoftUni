package ProgrammingFundamentals.Methods.Lab;

import java.util.Scanner;

public class P10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(getEvenSum(Math.abs(number)) * getOddSum(Math.abs(number)));

    }

    public static int getEvenSum(int number) {
        int evenSum = 0;

        while (number > 0) {
            int lastDigit = 0;

            lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                evenSum += lastDigit;
            }

            number /= 10;
        }

        return evenSum;
    }

    public static int getOddSum(int number) {
        int oddSum = 0;

        while (number > 0) {
            int lastDigit = 0;

            lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                oddSum += lastDigit;
            }
            number /= 10;
        }

        return oddSum;
    }
}
