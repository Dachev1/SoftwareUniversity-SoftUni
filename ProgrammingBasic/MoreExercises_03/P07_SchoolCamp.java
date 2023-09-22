package MoreExercises_03;

import java.util.Scanner;

public class P07_SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int countStudents = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());

        double pricePerNight = 0;
        String sport = "";

        if (season.equals("Winter")) {
            if (groupType.equals("boys")) {
                pricePerNight = 9.60;
                sport = "Judo";
            } else if (groupType.equals("girls")) {
                pricePerNight = 9.60;
                sport = "Gymnastics";
            } else {
                pricePerNight = 10;
                sport = "Ski";
            }
        } else if (season.equals("Spring")) {
            if (groupType.equals("boys")) {
                pricePerNight = 7.20;
                sport = "Tennis";
            } else if (groupType.equals("girls")) {
                pricePerNight = 7.20;
                sport = "Athletics";
            } else {
                pricePerNight = 9.50;
                sport = "Cycling";
            }
        } else if (season.equals("Summer")) {
            if (groupType.equals("boys")) {
                pricePerNight = 15;
                sport = "Football";
            } else if (groupType.equals("girls")) {
                pricePerNight = 15;
                sport = "Volleyball";
            } else {
                pricePerNight = 20;
                sport = "Swimming";
            }
        }

        double totalPrice = countStudents * pricePerNight * nights;
        if (countStudents >= 10 && countStudents < 20) {
            totalPrice *= 0.95;
        } else if (countStudents >= 20 && countStudents < 50) {
            totalPrice *= 0.85;
        } else if (countStudents >= 50) {
            totalPrice *= 0.50;
        }

        System.out.printf("%s %.2f lv.", sport, totalPrice);
    }
}
