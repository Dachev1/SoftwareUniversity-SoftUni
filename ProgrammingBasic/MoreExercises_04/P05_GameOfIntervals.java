package MoreExercises_04;

import java.util.Scanner;

public class P05_GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moves = Integer.parseInt(scanner.nextLine());

        double totalPoints = 0;
        int below9 = 0;
        int below19 = 0;
        int below29 = 0;
        int below39 = 0;
        int below50 = 0;
        int invalid = 0;

        for (int i = 1; i <= moves; i++) {
            double currentPoints = Double.parseDouble(scanner.nextLine());

            if (currentPoints >= 0 && currentPoints <= 9) {
                totalPoints += currentPoints * 0.20;
                below9++;
            } else if (currentPoints >= 10 && currentPoints <= 19) {
                totalPoints += currentPoints * 0.30;
                below19++;
            } else if (currentPoints >= 20 && currentPoints <= 29) {
                totalPoints += currentPoints * 0.40;
                below29++;
            } else if (currentPoints >= 30 && currentPoints <= 39) {
                totalPoints += 50;
                below39++;
            } else if (currentPoints >= 40 && currentPoints <= 50) {
                totalPoints += 100;
                below50++;
            } else {
                totalPoints /= 2;
                invalid++;
            }
        }

       double below9Percent = (below9 * 1.0 / moves) * 100;
       double below19Percent = (below19 * 1.0 / moves) * 100;
       double below29Percent = (below29 * 1.0 / moves) * 100;
       double below39Percent = (below39 * 1.0 / moves) * 100;
       double below50Percent = (below50 * 1.0 / moves) * 100;
       double invalidPercent = (invalid * 1.0 / moves) * 100;

        System.out.printf("%.2f%n", totalPoints);
        System.out.printf("From 0 to 9: %.2f%%%n", below9Percent);
        System.out.printf("From 10 to 19: %.2f%%%n", below19Percent);
        System.out.printf("From 20 to 29: %.2f%%%n", below29Percent);
        System.out.printf("From 30 to 39: %.2f%%%n", below39Percent);
        System.out.printf("From 40 to 50: %.2f%%%n", below50Percent);
        System.out.printf("Invalid numbers: %.2f%%%n", invalidPercent);
    }
}
