package Lecture_05;

import java.util.Scanner;

public class P03_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetNumber = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        while (sum < targetNumber) {
            int input = Integer.parseInt(scanner.nextLine());
            sum += input;
        }

        System.out.println(sum);
    }
}
