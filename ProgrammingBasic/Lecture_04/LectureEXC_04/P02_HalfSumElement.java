package Lecture_04.LectureEXC_04;

import java.util.Scanner;

public class P02_HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int maxNumber = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            sum += currentNumber;

            if (currentNumber > maxNumber) {
                maxNumber = currentNumber;
            }
        }

        int sumWithOutMaxNumber = sum - maxNumber;

        if (sumWithOutMaxNumber == maxNumber) {
            System.out.println("Yes");
            System.out.printf("Sum = " + sumWithOutMaxNumber);
        } else {
            int diff = Math.abs(sumWithOutMaxNumber - maxNumber);
            System.out.println("No");
            System.out.printf("Diff = " + diff);
        }
    }
}
