package Lecture_06;

import java.util.Scanner;

public class P04_SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());

        int count = 0;

        for (int num1 = start; num1 <= end ; num1++) {
            for (int num2 = start; num2 <= end ; num2++) {
                count++;

                if (num1 + num2 == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, num1, num2, magicNumber);
                    return;
                }
            }
        }

        System.out.printf("%d combinations - neither equals %d", count, magicNumber);
    }
}
