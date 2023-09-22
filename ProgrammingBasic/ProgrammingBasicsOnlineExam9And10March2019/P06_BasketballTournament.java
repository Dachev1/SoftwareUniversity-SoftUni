package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class P06_BasketballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tournamentName = scanner.nextLine();
        int matchesCount = Integer.parseInt(scanner.nextLine());

        int win = 0;
        int lost =0;
        int game = 0;

        while (!tournamentName.equals("End of tournaments")) {
            game += matchesCount;

            for (int games = 1; games <= matchesCount ; games++) {
                int pointsForDesiTeam = Integer.parseInt(scanner.nextLine());
                int pointsForEnemyTeam = Integer.parseInt(scanner.nextLine());

                int diff = Math.abs(pointsForDesiTeam - pointsForEnemyTeam);
                if (pointsForDesiTeam > pointsForEnemyTeam) {
                    System.out.printf("Game %d of tournament %s: win with %d points.%n", games, tournamentName, diff);
                    win++;
                } else {
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", games, tournamentName, diff);
                    lost++;
                }
            }

            tournamentName = scanner.nextLine();
            if (tournamentName.equals("End of tournaments")) {
                System.out.printf("%.2f%% matches win%n", (win * 1.0 / game) * 100);
                System.out.printf("%.2f%% matches lost%n", (lost * 1.0 / game) * 100);
                break;
            }
            matchesCount = Integer.parseInt(scanner.nextLine());
        }
    }
}
