package ProgrammingBasicsOnlineExam15And16June2019;

import java.util.Scanner;

public class P03_MovieDestination {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if (destination.equals("Dubai")) {
            if (season.equals("Winter")) {
                price += 45000 * 0.70;
            } else  if (season.equals("Summer")) {
                price += 40000 * 0.70;
            }
        } if (destination.equals("Sofia")) {
            if (season.equals("Winter")) {
                price += 17000 * 1.25;
            } else  if (season.equals("Summer")) {
                price += 12500 * 1.25;
            }
        } if (destination.equals("London")) {
            if (season.equals("Winter")) {
                price += 24000;
            } else  if (season.equals("Summer")) {
                price += 20250;
            }
        }

        price *= days;

        double diff = Math.abs(budget - price);

        if (budget >= price) {
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", diff);
        } else {
            System.out.printf("The director needs %.2f leva more!", diff);
        }
    }
}
