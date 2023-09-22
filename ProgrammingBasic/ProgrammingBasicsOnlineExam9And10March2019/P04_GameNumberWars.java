package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class P04_GameNumberWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String player1Name = scanner.nextLine();
        String player2Name = scanner.nextLine();

        int player1Points = 0;
        int player2Points = 0;

        String input = scanner.nextLine();

        while (!input.equals("End of game")) {
            int player1Card = Integer.parseInt(input);
            int player2Card = Integer.parseInt(scanner.nextLine());

            if (player1Card > player2Card) {
                player1Points += player1Card - player2Card;
            } else if (player2Card > player1Card) {
                player2Points += player2Card - player1Card;
            } else {
                System.out.println("Number wars!");
                player1Card = Integer.parseInt(scanner.nextLine());
                player2Card = Integer.parseInt(scanner.nextLine());

                if (player1Card > player2Card) {
                    System.out.printf("%s is winner with %d points", player1Name, player1Points);
                } else {
                    System.out.printf("%s is winner with %d points", player2Name, player2Points);
                }
                break;
            }
            input = scanner.nextLine();
        }

        if (input.equals("End of game")) {
            System.out.printf("%s has %d points%n", player1Name, player1Points);
            System.out.printf("%s has %d points", player2Name, player2Points);
        }
    }
}
