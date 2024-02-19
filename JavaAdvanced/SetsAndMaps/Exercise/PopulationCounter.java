package SetsAndMaps.Exercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countryData = new LinkedHashMap<>();
        Map<String, Long> totalPopulationOfCountry = new LinkedHashMap<>();

        String line;
        while (!"report".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            countryData.putIfAbsent(country, new LinkedHashMap<>());
            countryData.get(country).put(city, population);


            totalPopulationOfCountry.putIfAbsent(country, 0L);
            totalPopulationOfCountry.put(country, totalPopulationOfCountry.get(country) + population);

        }

        totalPopulationOfCountry.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());

                    countryData.get(entry.getKey())
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(pair -> {
                                System.out.printf("=>%s: %d\n", pair.getKey(), pair.getValue());
                            });
                });

    }
}
