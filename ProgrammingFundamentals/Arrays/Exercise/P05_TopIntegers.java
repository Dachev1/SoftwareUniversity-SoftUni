package ProgrammingFundamentals.Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            boolean isTopInt = true;

            for (int j = i + 1; j < numbers.length; j++) {
                    int nextNumber = numbers[j];


                    if (currentNumber <= nextNumber) {
                        isTopInt = false;
                        break;
                    }
            }

            if (isTopInt) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}
