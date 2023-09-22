package ProgrammingBasicsOnlineExam6And7April2019;

import java.util.Scanner;

public class P05_MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int movieCount = Integer.parseInt(scanner.nextLine());

        double theHighestRated = Double.MIN_VALUE;
        double theLowestRated = Double.MAX_VALUE;
        double averageRating = 0;

        String theHighestName = "";
        String theLowestName = "";
        for (int i = 1; i <= movieCount ; i++) {
            String movieName = scanner.nextLine();
            double rating = Double.parseDouble(scanner.nextLine());
            averageRating += rating;

            if (rating > theHighestRated) {
                theHighestRated = rating;
                theHighestName = movieName;
            }
            if (rating < theLowestRated) {
                theLowestRated = rating;
                theLowestName = movieName;
            }
        }

        System.out.printf("%s is with highest rating: %.1f%n", theHighestName, theHighestRated);
        System.out.printf("%s is with lowest rating: %.1f%n", theLowestName, theLowestRated);
        System.out.printf("Average rating: %.1f", averageRating / movieCount);
    }
}
