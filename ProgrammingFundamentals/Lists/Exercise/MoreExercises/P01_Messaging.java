package ProgrammingFundamentals.Lists.Exercise.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<String> text = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            int sumOfDigits = 0;
            while (number > 0) {
                int lastDigit = number % 10;
                sumOfDigits += lastDigit;
                number /= 10;
            }

            while (sumOfDigits > text.size()) {
                sumOfDigits -= text.size();
            }

            System.out.print(text.get(sumOfDigits));
            text.remove(sumOfDigits);
        }
    }
}
