package MoreExercises_04;

import java.util.Scanner;

public class P03_Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loads = Integer.parseInt(scanner.nextLine());

        int van = 0;
        int truck = 0;
        int train = 0;

        for (int i = 1; i <= loads; i++) {
            int tone = Integer.parseInt(scanner.nextLine());

            if (tone <= 3) {
                van += tone;
            } else if (tone <= 11) {
                truck += tone;
            } else {
                train += tone;
            }
        }

        int totalTones = van + truck + train;
        double averageTone = (((van * 1.0) * 200) + ((truck * 1.0) * 175) + ((train * 1.0) * 120)) / totalTones;

        double vanPercent = ((van * 1.0) / totalTones) * 100;
        double truckPercent = ((truck * 1.0) / totalTones) * 100;
        double trainPercent = ((train * 1.0) / totalTones) * 100;

        System.out.printf("%.2f%n", averageTone);
        System.out.printf("%.2f%%%n", vanPercent);
        System.out.printf("%.2f%%%n", truckPercent);
        System.out.printf("%.2f%%%n", trainPercent);
    }
}
