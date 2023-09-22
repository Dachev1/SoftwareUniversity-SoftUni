package Lecture_03.LectureEXC_03;

import java.util.Scanner;

public class P05_Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        String campOrHotel = "";
        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equals("summer")) {
                campOrHotel = "Camp";
                budget = budget * 0.3;
            } else {
                campOrHotel = "Hotel";
                budget = budget * 0.7;
            }
        } else if (budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")) {
                campOrHotel = "Camp";
                budget = budget * 0.4;
            } else {
                campOrHotel = "Hotel";
                budget = budget * 0.8;
            }
        } else {
            destination = "Europe";
            campOrHotel = "Hotel";
            budget = budget * 0.9;
        }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", campOrHotel, budget);
    }
}
