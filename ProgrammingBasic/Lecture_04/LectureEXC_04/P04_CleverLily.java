package Lecture_04.LectureEXC_04;

import java.util.Scanner;

public class P04_CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double priceWashingMachine = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int toysCount = 0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                sum += (i * 5) - 1;
            } else {
                toysCount++;
            }
        }

        sum += toysCount * toyPrice;
        double diff = Math.abs(sum - priceWashingMachine);

        if (sum >= priceWashingMachine) {
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);
        }
    }
}
