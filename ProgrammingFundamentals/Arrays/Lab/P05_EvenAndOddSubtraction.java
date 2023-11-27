package ProgrammingFundamentals.Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];

            if (currentNum % 2 == 0) {
                evenSum += currentNum;
            } else {
                oddSum += currentNum;
            }
        }

        System.out.println(evenSum - oddSum);
    }
}
