package ProgrammingBasicsOnlineExam15And16June2019;

import java.util.Scanner;

public class P01_MovieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        int ticketsCount = Integer.parseInt(scanner.nextLine());
        double ticketPrice = Double.parseDouble(scanner.nextLine());
        int percentForCinema = Integer.parseInt(scanner.nextLine());

        double ticketsTotalPrice = ticketsCount * ticketPrice;
        double incomeForAllPeriod = ticketsTotalPrice * days;
        double percent = incomeForAllPeriod * percentForCinema / 100;
        double incomeForMovie = incomeForAllPeriod - percent;


        System.out.printf("The profit from the movie %s is %.2f lv.", movieName, incomeForMovie);
    }
}
