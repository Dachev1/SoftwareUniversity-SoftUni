package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isUpperCase = str -> Character.isUpperCase(str.charAt(0));

        List<String> upperCaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(isUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(System.out::println);
    }
}
