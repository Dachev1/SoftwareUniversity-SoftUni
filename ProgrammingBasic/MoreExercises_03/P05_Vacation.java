package MoreExercises_03;

import java.util.Scanner;

public class P05_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String roomType = "";
        String location = "";
        double price = 0;

        if (budget <= 1000) {
            roomType = "Camp";

            if(season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.65;
            } else {
                location = "Morocco";
                price = budget * 0.45;
            }
        } else if (budget <= 3000) {
            roomType = "Hut";

            if(season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.80;
            } else {
                location = "Morocco";
                price = budget * 0.60;
            }
        } else {
            roomType = "Hotel";
            if(season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.90;
            } else {
                location = "Morocco";
                price = budget * 0.90;
            }
        }

        System.out.printf("%s - %s - %.2f", location, roomType, price);
    }
}
