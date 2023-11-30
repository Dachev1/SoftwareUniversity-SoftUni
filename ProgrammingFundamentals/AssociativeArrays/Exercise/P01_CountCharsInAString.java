package ProgrammingFundamentals.AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();
        Map<Character, Integer> wordStats = new LinkedHashMap<>();

        for (char el : input.toCharArray()) {

            if (!Character.isWhitespace(el)) {
                wordStats.putIfAbsent(el, 0);

                wordStats.put(el, wordStats.get(el) + 1);
            }
        }
        wordStats.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
