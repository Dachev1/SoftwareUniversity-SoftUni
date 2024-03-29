package SetsAndMaps.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> chemicalElements = new TreeSet<>();
        
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            chemicalElements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }

        chemicalElements.forEach(el -> System.out.printf("%s ", el));
    }
}
