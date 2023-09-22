package ProgrammingBasicsOnlineExam15And16June2019;

import java.util.Scanner;

public class P01_SeriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String serialName = scanner.nextLine();
        int seasonsCount = Integer.parseInt(scanner.nextLine());
        int episodesCount = Integer.parseInt(scanner.nextLine());
        double durationForEpisode = Double.parseDouble(scanner.nextLine());

        double advertisements = durationForEpisode * 0.20;
        double durationForEpisodeWithAdvertisements = durationForEpisode + advertisements;
        double  specialEpisode = seasonsCount * 10;

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", serialName, durationForEpisodeWithAdvertisements * episodesCount * seasonsCount +  specialEpisode);
    }
}
