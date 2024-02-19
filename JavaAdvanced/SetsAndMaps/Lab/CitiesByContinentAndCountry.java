import java.util.*;

public class CitiesByContinentAndCountry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continents = tokens[0];
            String countries = tokens[1];
            String cities  = tokens[2];

            data.putIfAbsent(continents, new LinkedHashMap<>());

            Map<String, List<String>> innerMap = data.get(continents);
            innerMap.putIfAbsent(countries, new ArrayList<>());
            innerMap.get(countries).add(cities);
        }

        data.forEach((continents, values) -> {
            System.out.printf("%s:\n", continents);

            values.forEach((countries, cities) -> {
                System.out.printf("%s -> %s\n", countries, String.join(", ", cities));
            });
        });
    }
}
