package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<Integer> evenNumbers = num -> num % 2 == 0;

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .filter(evenNumbers)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", numbersList.toString().replaceAll("[\\[\\]]", "")));

        Collections.sort(numbersList);
        System.out.println(String.join(", ", numbersList.toString().replaceAll("[\\[\\]]", "")));
    }
}
