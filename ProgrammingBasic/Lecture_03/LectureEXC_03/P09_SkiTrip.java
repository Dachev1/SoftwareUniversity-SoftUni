package Lecture_03.LectureEXC_03;

import java.util.Scanner;

public class P09_SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine().toLowerCase();
        String grade = scanner.nextLine();

        int nights = days - 1;

        double price = 0;

        if (roomType.equals("room for one person")) {
            price = 18 * nights;
        } else if (roomType.equals("apartment")) {
            price = 25 * nights;

            if (nights < 10) {
                price = price * 0.70;
            } else if (nights <= 15) {
                price = price * 0.65;
            } else {
                price = price * 0.50;
            }
        } else if (roomType.equals("president apartment")) {
            price = 35 * nights;

            if (nights < 10) {
                price = price * 0.90;
            } else if (nights <= 15) {
                price = price * 0.85;
            } else {
                price = price * 0.80;
            }
        }
        if (grade.equals("positive")) {
            price = price * 1.25;
            System.out.printf("%.2f", price);
        } else {
            price = price * 0.90;
            System.out.printf("%.2f", price);
        }
    }
}
