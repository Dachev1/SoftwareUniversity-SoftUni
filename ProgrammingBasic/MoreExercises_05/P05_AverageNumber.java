package MoreExercises_05;

import java.util.Scanner;

public class P05_AverageNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int total = 0;
        int numbersCount = 0;

        for (int i = 1; i <= n ; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            total += currentNumber;
            numbersCount++;
        }

        System.out.printf("%.2f", total * 1.0 / numbersCount);
    }
}
