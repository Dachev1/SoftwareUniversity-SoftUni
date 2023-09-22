package ProgrammingBasicsOnlineExam6And7April2019;

import java.util.Scanner;

public class P06_CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();

        int standardTickets = 0;
        int studentTickets = 0;
        int kidTickets = 0;
        int totalTickets = 0;

        while (!movieName.equals("Finish")) {
            int freeSeats = Integer.parseInt(scanner.nextLine());
            String ticketType = scanner.nextLine();

            int countTicketsPerMovie = 0;
            while (!ticketType.equals("End")) {
                countTicketsPerMovie++;

                if (ticketType.equals("standard")) {
                    standardTickets++;
                } else if (ticketType.equals("student")) {
                    studentTickets++;
                } else if (ticketType.equals("kid")) {
                    kidTickets++;
                }
                if (countTicketsPerMovie == freeSeats) {
                    break;
                }
                ticketType = scanner.nextLine();
            }


            totalTickets += countTicketsPerMovie;

            System.out.printf("%s - %.2f%% full.%n", movieName, (countTicketsPerMovie * 1.0 / freeSeats) * 100);


            movieName = scanner.nextLine();
        }

        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", (studentTickets * 1.0 / totalTickets) * 100);
        System.out.printf("%.2f%% standard tickets.%n", (standardTickets * 1.0 / totalTickets) * 100);
        System.out.printf("%.2f%% kids tickets.%n", (kidTickets * 1.0 / totalTickets) * 100);

    }
}
















