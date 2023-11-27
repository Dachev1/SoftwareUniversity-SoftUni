package ProgrammingFundamentals.Lists.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07_RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);

            if (currentNumber < 0) {
                numbers.remove(Integer.valueOf(currentNumber));
                i--;
            }
        }

        if (numbers.size() > 0) {
            Collections.reverse(numbers);

            for (int number : numbers) {
                System.out.print(number + " ");
            }
        } else {
            System.out.println("empty");
        }
    }
}
