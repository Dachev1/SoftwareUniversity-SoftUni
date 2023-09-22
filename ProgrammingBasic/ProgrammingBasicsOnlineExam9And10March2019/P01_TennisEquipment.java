package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class P01_TennisEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForOneRacket = Double.parseDouble(scanner.nextLine());
        int racketsCount = Integer.parseInt(scanner.nextLine());
        int sneakersCount = Integer.parseInt(scanner.nextLine());


        double priceForRackets = priceForOneRacket * racketsCount;
        double priceForSneakers = (priceForOneRacket / 6) * sneakersCount;
        double priceForOthers = (priceForSneakers + priceForRackets) * 0.2;

        double sum = priceForRackets + priceForSneakers + priceForOthers;

        double priceForDjokovic = sum / 8;
        double priceForSponsors = sum * 7 / 8;

        System.out.printf("Price to be paid by Djokovic %.0f%n", Math.floor(priceForDjokovic));
        System.out.printf("Price to be paid by sponsors %.0f%n", Math.ceil(priceForSponsors));

    }
}
