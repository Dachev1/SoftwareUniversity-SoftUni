package MoreExercises_03;

import java.util.Scanner;

public class P10_MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());
        double sum = 0;

        while (true) {
            if (num < 0) {
                System.out.println("Negative number!");
                break;
            }
            sum = num * 2;
            System.out.printf("Result: %.2f%n", sum);
            num = Double.parseDouble(scanner.nextLine());
        }
    }
}
