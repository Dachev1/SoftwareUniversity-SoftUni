package MoreExercises_04;

import java.util.Scanner;

public class P07_FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacityOfStadium = Integer.parseInt(scanner.nextLine());
        int fensCount = Integer.parseInt(scanner.nextLine());

        int A = 0;
        int B = 0;
        int V = 0;
        int G = 0;

        for (int i = 1; i <= fensCount; i++) {
            String currentSector = scanner.nextLine();

            if (currentSector.equals("A")) {
                A++;
            } else if (currentSector.equals("B")) {
                B++;
            } else if (currentSector.equals("V")) {
                V++;
            } else if (currentSector.equals("G")) {
                G++;
            }
        }

        double aSectorPercent = (A * 1.0 / fensCount) * 100;
        double bSectorPercent = (B * 1.0 / fensCount) * 100;
        double vSectorPercent = (V * 1.0 / fensCount) * 100;
        double gSectorPercent = (G * 1.0 / fensCount) * 100;

        System.out.printf("%.2f%%%n", aSectorPercent);
        System.out.printf("%.2f%%%n", bSectorPercent);
        System.out.printf("%.2f%%%n", vSectorPercent);
        System.out.printf("%.2f%%%n", gSectorPercent);
        System.out.printf("%.2f%%%n", (fensCount * 1.0 / capacityOfStadium) * 100);
    }
}
