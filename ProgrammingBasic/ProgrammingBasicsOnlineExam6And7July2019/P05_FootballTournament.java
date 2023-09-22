package ProgrammingBasicsOnlineExam6And7July2019;

import java.util.Scanner;

public class P05_FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String team = scanner.nextLine();
        int matchesPlayed = Integer.parseInt(scanner.nextLine());

        int earnPoints = 0;
        int win = 0;
        int lose = 0;
        int draw = 0;

        if (matchesPlayed == 0) {
            System.out.printf("%s hasn't played any games during this season.", team);
            return;
        }

        for (int i = 1; i <= matchesPlayed ; i++) {

            String result = scanner.nextLine();

            if (result.equals("W")) {
                win++;
                earnPoints += 3;
            } else if (result.equals("D")) {
                draw++;
                earnPoints += 1;
            } else if (result.equals("L")) {
                lose++;
            }
        }

        System.out.printf("%s has won %d points during this season.%n", team, earnPoints);
        System.out.println("Total stats:");
        System.out.printf("## W: %d%n", win);
        System.out.printf("## D: %d%n", draw);
        System.out.printf("## L: %d%n", lose);
        System.out.printf("Win rate: %.2f%%", (win * 1.0 / matchesPlayed) * 100);

    }
}
