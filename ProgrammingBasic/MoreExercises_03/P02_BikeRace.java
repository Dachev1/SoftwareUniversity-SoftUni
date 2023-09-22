package MoreExercises_03;

import java.util.Scanner;

public class P02_BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String trackType = scanner.nextLine();

        double juniorsTax = 0;
        double seniorsTax = 0;
        if (trackType.equals("trail")) {
            juniorsTax = 5.50;
            seniorsTax = 7;
        } else if (trackType.equals("cross-country")) {
            juniorsTax = 8;
            seniorsTax = 9.50;

            int totalBikers = juniors + seniors;
            if (totalBikers >= 50) {
                juniorsTax = juniorsTax * 0.75;
                seniorsTax = seniorsTax * 0.75;
            }
        } else if (trackType.equals("downhill")) {
            juniorsTax = 12.25;
            seniorsTax = 13.75;
        } else if (trackType.equals("road")) {
            juniorsTax = 20;
            seniorsTax = 21.50;
        }

        double sum = ((juniors * juniorsTax) + (seniors * seniorsTax)) * 0.95;
        System.out.printf("%.2f", sum);
    }
}
