package EXAM;

import java.util.Scanner;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String grade = scanner.nextLine();

        int nights = days - 1;
        double price = 0;

        if (roomType.equals("room for one person")) {
            price = 18 * nights;
        } else if (roomType.equals("apartment")) {
            price = 25 * nights;
            if (days < 10) {
                price *= 0.70;
            } else if (days <= 15) {
                price *= 0.65;
            } else {
                price *= 0.50;
            }
        } else if (roomType.equals("president apartment")) {
            price = 35 * nights;
            if (days < 10) {
                price *= 0.90;
            } else if (days <= 15) {
                price *= 0.85;
            } else {
                price *= 0.80;
            }
        }

        if (grade.equals("positive")) {
            price *= 1.25;
        } else {
            price *= 0.90;
        }

        System.out.printf("%.2f", price);
    }
}