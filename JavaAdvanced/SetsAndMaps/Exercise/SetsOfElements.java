package SetsAndMaps.Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = tokens[0];
        int m = tokens[1];

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            firstSet.add(scanner.nextLine());
        }

        for (int i = 0; i < m; i++) {
            secondSet.add(scanner.nextLine());
        }

        firstSet.retainAll(secondSet);
        System.out.println(String.join(" ", firstSet));
    }
}
