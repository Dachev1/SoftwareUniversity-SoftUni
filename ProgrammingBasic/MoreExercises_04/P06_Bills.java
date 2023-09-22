package MoreExercises_04;

import java.util.Scanner;

public class P06_Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());

        double electricityPrice = 0;
        double waterPrice = 0;
        double internetPrice = 0;
        double otherPrice = 0;

        for (int i = 1; i <= months; i++) {
            double price = Double.parseDouble(scanner.nextLine());
            electricityPrice += price;
        }

        waterPrice = months * 20;
        internetPrice = months * 15;
        otherPrice = (electricityPrice + waterPrice + internetPrice) * 1.20;

        double averagePrice = (electricityPrice + internetPrice + waterPrice + otherPrice) / months;

        System.out.printf("Electricity: %.2f lv%n", electricityPrice);
        System.out.printf("Water: %.2f lv%n", waterPrice);
        System.out.printf("Internet: %.2f lv%n", internetPrice);
        System.out.printf("Other: %.2f lv%n", otherPrice);
        System.out.printf("Average: %.2f lv%n", averagePrice);
    }
}
