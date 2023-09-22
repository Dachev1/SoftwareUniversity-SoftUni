package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class P03_WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stage = scanner.nextLine();
        String ticketType = scanner.nextLine();
        int ticketsCount = Integer.parseInt(scanner.nextLine());
        String photo = scanner.nextLine();

        double ticketPrice = 0;

        if (stage.equals("Quarter final")) {
            if (ticketType.equals("Standard")) {
                ticketPrice = 55.50;
            } else if (ticketType.equals("Premium")) {
                ticketPrice = 105.20;
            } else if (ticketType.equals("VIP")) {
                ticketPrice = 118.90;
            }
        } else if (stage.equals("Semi final")) {
            if (ticketType.equals("Standard")) {
                ticketPrice = 75.88;
            } else if (ticketType.equals("Premium")) {
                ticketPrice = 125.22;
            } else if (ticketType.equals("VIP")) {
                ticketPrice = 300.40;
            }
        } else if (stage.equals("Final")) {
            if (ticketType.equals("Standard")) {
                ticketPrice = 110.10;
            } else if (ticketType.equals("Premium")) {
                ticketPrice = 160.66;
            } else if (ticketType.equals("VIP")) {
                ticketPrice = 400;
            }
        }

        double price = ticketsCount * ticketPrice;
        if (price > 4000) {
            price *= 0.75;
        } else if ( price > 2500) {
            price *= 0.90;
        }

        if (photo.equals("Y") && price <= 4000) {
            price += ticketsCount * 40;
        }

        System.out.printf("%.2f", price );
    }
}
