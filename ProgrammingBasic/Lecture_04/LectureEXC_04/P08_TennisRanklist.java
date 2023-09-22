package Lecture_04.LectureEXC_04;

import java.util.Scanner;

public class P08_TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournamentsCount = Integer.parseInt(scanner.nextLine());
        int startingPoints= Integer.parseInt(scanner.nextLine());

        int totalPoints = startingPoints;

        int earnPoints = 0;
        int wonTournaments = 0;


        for (int i = 1; i <= tournamentsCount; i++) {
            String reachedStage = scanner.nextLine();

            if (reachedStage.equals("W")) {
                earnPoints += 2000;
                totalPoints += 2000;
                wonTournaments++;
            } else if (reachedStage.equals("F")) {
                earnPoints += 1200;
                totalPoints += 1200;
            } else if (reachedStage.equals("SF")) {
                earnPoints += 720;
                totalPoints += 720;
            }
        }

        int averagePoints = (earnPoints / tournamentsCount);
        double winningTournamentPercent = (wonTournaments * 1.0 / tournamentsCount) * 100;

        System.out.printf("Final points: %d%n", totalPoints);
        System.out.printf("Average points: %d%n", averagePoints);
        System.out.printf("%.2f%%%n", winningTournamentPercent);
    }
}

