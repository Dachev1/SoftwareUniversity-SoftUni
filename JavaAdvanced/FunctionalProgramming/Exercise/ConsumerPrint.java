package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(System.out::println);
    }
}
