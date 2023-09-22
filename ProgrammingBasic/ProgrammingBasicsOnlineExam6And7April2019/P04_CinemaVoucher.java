package ProgrammingBasicsOnlineExam6And7April2019;

import java.util.Scanner;

public class P04_CinemaVoucher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int valueOfVoucher = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int filmTickets = 0;
        int others = 0;

        while (!input.equals("End")) {
            int price = 0;
            if (input.length() > 8) {
                price = input.charAt(0) + input.charAt(1);
                filmTickets++;
            } else {
                price = input.charAt(0);
                others++;
            }

            valueOfVoucher -= price;

            if (valueOfVoucher < 0) {
                if (input.length() > 8) {
                    filmTickets--;
                } else {
                    others--;
                }
                break;
            }


            input = scanner.nextLine();
        }

        System.out.printf("%d%n", filmTickets);
        System.out.printf("%d", others);
    }
}
