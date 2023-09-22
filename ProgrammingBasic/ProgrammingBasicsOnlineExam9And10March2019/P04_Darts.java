package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class P04_Darts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();
        int totalPoints = 301;
        int successfulShots = 0;
        int unSuccessfulShots = 0;

       while (totalPoints != 0) {
           String command = scanner.nextLine();
           if ("Retire".equals(command)) {
               break;
           }
           int points = parseInt(scanner.nextLine());

           if ("Triple".equals(command)) {
               points *= 3;
           } else if ("Double".equals(command)) {
               points *= 2;
           }

           if (totalPoints - points >= 0) {
               totalPoints -= points;
               successfulShots++;
           } else {
               unSuccessfulShots++;
           }
       }

        if (totalPoints == 0) {
            System.out.printf("%s won the leg with %d shots.", playerName, successfulShots);
        } else {
            System.out.printf("%s retired after %d unsuccessful shots.", playerName, unSuccessfulShots);
        }
    }
}

