package MoreExercises_04;

import java.util.Scanner;

public class P01_BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inheritedMoney = Double.parseDouble(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());

        int age = 18;
        double spendMoney = 0;

        for (int i = 1800; i <= year; i++) {
            if (i % 2 == 0) {
                spendMoney += 12000;
                age++;
            } else {
                spendMoney += 12000 + (age * 50);
                age++;
            }
        }

        double diff = Math.abs(inheritedMoney - spendMoney);
        if (inheritedMoney >= spendMoney) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", diff);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", diff);
        }
    }
}
