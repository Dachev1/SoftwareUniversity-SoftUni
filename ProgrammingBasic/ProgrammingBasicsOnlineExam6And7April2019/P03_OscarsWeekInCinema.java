package ProgrammingBasicsOnlineExam6And7April2019;

import java.util.Scanner;

public class P03_OscarsWeekInCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        String hallType = scanner.nextLine();
        int ticketsCount = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if (movieName.equals("A Star Is Born")) {
            if (hallType.equals("normal")) {
                price = 7.50;
            } else if (hallType.equals("luxury")) {
                price = 10.50;
            } else if (hallType.equals("ultra luxury")) {
                price = 13.50;
            }
        } else if (movieName.equals("Bohemian Rhapsody")) {
            if (hallType.equals("normal")) {
                price = 7.35;
            } else if (hallType.equals("luxury")) {
                price = 9.45;
            } else if (hallType.equals("ultra luxury")) {
                price = 12.75;
            }
        } else if (movieName.equals("Green Book")) {
            if (hallType.equals("normal")) {
                price = 8.15;
            } else if (hallType.equals("luxury")) {
                price = 10.25;
            } else if (hallType.equals("ultra luxury")) {
                price = 13.25;
            }
        } else if (movieName.equals("The Favourite")) {
            if (hallType.equals("normal")) {
                price = 8.75;
            } else if (hallType.equals("luxury")) {
                price = 11.55;
            } else if (hallType.equals("ultra luxury")) {
                price = 13.95;
            }
        }

        System.out.printf("%s -> %.2f lv.", movieName, ticketsCount * price);
    }
}
