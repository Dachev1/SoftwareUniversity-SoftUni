package ProgrammingBasicsOnlineExam6And7July2019;

import java.util.Scanner;

public class P05_PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gamesSold = Integer.parseInt(scanner.nextLine());

        int hearthstone = 0;
        int fornite = 0;
        int overwatch = 0;
        int others = 0;

        for (int i = 1; i <= gamesSold ; i++) {
            String gameName = scanner.nextLine();

            if (gameName.equals("Hearthstone")) {
                hearthstone++;
            } else if (gameName.equals("Fornite")) {
                fornite++;
            } else if (gameName.equals("Overwatch")) {
                overwatch++;
            }  else {
                others++;
            }
        }

        System.out.printf("Hearthstone - %.2f%%%n", hearthstone * 1.0 / gamesSold * 100);
        System.out.printf("Fornite - %.2f%%%n", fornite * 1.0 / gamesSold * 1.0 * 100);
        System.out.printf("Overwatch - %.2f%%%n", overwatch * 1.0 / gamesSold * 1.0 * 100);
        System.out.printf("Others - %.2f%%%n", others * 1.0  / gamesSold * 1.0 * 100);
    }
}
