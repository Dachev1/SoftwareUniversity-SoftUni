package ProgrammingBasicsOnlineExam15And16June2019;

import java.util.Scanner;

public class P03_FilmPremiere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        String packetForMovie = scanner.nextLine();
        int ticketsCount = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if (movieName.equals("John Wick")) {
            if (packetForMovie.equals("Drink")) {
                price = 12;
            } else if (packetForMovie.equals("Popcorn")) {
                price = 15;
            } else if (packetForMovie.equals("Menu")) {
                price = 19;
            }
        } else if (movieName.equals("Star Wars")) {
            if (packetForMovie.equals("Drink")) {
                price = 18;
            } else if (packetForMovie.equals("Popcorn")) {
                price = 25;
            } else if (packetForMovie.equals("Menu")) {
                price = 30;
            }
        } else if (movieName.equals("Jumanji")) {
            if (packetForMovie.equals("Drink")) {
                price = 9;
            } else if (packetForMovie.equals("Popcorn")) {
                price = 11;
            } else if (packetForMovie.equals("Menu")) {
                price = 14;
            }
        }

        price *= ticketsCount;

        if (movieName.equals("Star Wars") && ticketsCount >= 4) {
            price *= 0.70;
        } else if (movieName.equals("Jumanji") && ticketsCount == 2) {
            price *= 0.85;
        }

        System.out.printf("Your bill is %.2f leva.", price);
    }
}
