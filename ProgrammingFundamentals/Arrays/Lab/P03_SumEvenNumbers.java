package ProgrammingFundamentals.Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                         .toArray();

        int evenSum = 0;
        for (int i = 0; i < numbersArr.length; i++) {
            int currentNumber = numbersArr[i];

            if (currentNumber % 2 == 0) {
                evenSum += currentNumber;
            }
        }

        System.out.println(evenSum);
    }
}
