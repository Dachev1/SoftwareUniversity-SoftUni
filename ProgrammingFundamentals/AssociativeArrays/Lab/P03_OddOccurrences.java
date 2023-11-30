package ProgrammingFundamentals.AssociativeArrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().toLowerCase().split(" ");
        LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();

        for (String word : text) {

            wordMap.putIfAbsent(word, 0);

            wordMap.put(word, wordMap.get(word) + 1);
        }

            String[] result = wordMap
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() % 2 != 0)
                    .map(entry -> entry.getKey())
                    .toArray(String[]::new);

        System.out.println(String.join(", ", result));
        }
    }
