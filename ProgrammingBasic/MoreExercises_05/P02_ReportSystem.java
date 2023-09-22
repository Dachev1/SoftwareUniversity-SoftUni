package MoreExercises_05;

import java.util.Scanner;

public class P02_ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int neededMoney = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int earnedMoney = 0;
        int cashCount = 0;
        int cardCount = 0;
        int cashMoney = 0;
        int cardMoney = 0;

        while (!command.equals("End")) {
            int cash = Integer.parseInt(command);
            int card = Integer.parseInt(scanner.nextLine());

            if (cash > 100) {
                System.out.println("Error in transaction!");
            } else {
                System.out.println("Product sold!");
                cashMoney += cash;
                cashCount++;
            }
            if (card < 10) {
                System.out.println("Error in transaction!");
            } else {
                System.out.println("Product sold!");
                cardMoney += card;
                cardCount++;
            }

            earnedMoney = cashMoney + cardMoney;
            if (earnedMoney >= neededMoney) {
                break;
            }
            command = scanner.nextLine();
        }

        if (command.equals("End")) {
            System.out.println("Failed to collect required money for charity.");
        } else {
            System.out.printf("Average CS: %.2f%n", cashMoney * 1.0 / cashCount);
            System.out.printf("Average CC: %.2f", cardMoney * 1.0  / cardCount);
        }
    }
}
