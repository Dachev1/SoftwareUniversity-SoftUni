package SetsAndMaps.Exercise;

import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersData = new LinkedHashMap<>();

        String line;
        while (!"JOKER".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(": ");
            String name = tokens[0];

            playersData.putIfAbsent(name, new HashSet<>());
            Arrays.stream(tokens[1].split(",\\s+")).forEach(playersData.get(name)::add);
        }

        playersData.forEach((player, cards) -> {
            int points = getPoints(cards);
            System.out.printf("%s: %d\n", player, points);
        });
    }

    private static int getPoints(Set<String> cards) {
        int points = 0;

        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            String type = String.valueOf(card.charAt(card.length() - 1));

            int powerInNumber = getPower(power);
            int typeInNumber = getType(type);

            points += powerInNumber * typeInNumber;
        }

        return points;
    }

    private static int getType(String type) {
        switch (type) {
            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            case "C":
                return 1;
        }

        return 0;
    }

    private static int getPower(String power) {
        switch (power) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
        }

        return 0;
    }
}
