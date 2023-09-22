package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class P02_FootballResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int win = 0;
        int lost = 0;
        int draw = 0;

        for (int i = 1; i <= 3; i++) {
            String result = scanner.nextLine();
            int team1 = result.charAt(0);
            int team2 = result.charAt(2);

            if (team1 > team2) {
                win++;
            } else  if (team1 < team2) {
                lost++;
            } else {
                draw++;
            }
        }

        System.out.printf("Team won %d games.%n", win);
        System.out.printf("Team lost %d games.%n", lost);
        System.out.printf("Drawn games: %d%n", draw);
    }
}
