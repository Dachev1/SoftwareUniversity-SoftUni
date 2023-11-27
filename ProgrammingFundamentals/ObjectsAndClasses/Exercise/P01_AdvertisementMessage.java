package ProgrammingFundamentals.ObjectsAndClasses.Exercise;

import java.util.Random;
import java.util.Scanner;

public class P01_AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrases = {
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."
        };

        String[] events = {
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"

        };

        String[] authors = {
                "Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"
        };

        String[] cities = {
                "Burgas",
                "Sofia",
                "Plovdiv",
                "Varna",
                "Ruse"
        };

        Random rdm = new Random();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String randomPhase = phrases[rdm.nextInt(phrases.length)];
            String randomEvent = events[rdm.nextInt(events.length)];
            String randomAuthor = authors[rdm.nextInt(authors.length)];
            String randomCities = cities[rdm.nextInt(cities.length)];

            System.out.printf("%s %s %s – %s.\n", randomPhase, randomEvent, randomAuthor, randomCities);
        }
    }
}
