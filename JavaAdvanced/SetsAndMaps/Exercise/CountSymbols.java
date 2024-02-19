package SetsAndMaps.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> symbolsCounter = new TreeMap<>();

        String text = scanner.nextLine();

        for (char chr : text.toCharArray()) {
            symbolsCounter.putIfAbsent(chr, 0);
            int newCount = symbolsCounter.get(chr) + 1;
            symbolsCounter.put(chr, newCount);
        }

        symbolsCounter.forEach((k, v) -> {
            System.out.printf("%c: %d time/s\n", k, v);
        });
    }
}
