package ProgrammingFundamentals.Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 1 2 3 3

        for (int i = 0; i < numbers.length; i++) {
            int midIndex = i;
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < midIndex; j++) {
                leftSum += numbers[j];
            }

            for (int j = numbers.length - 1; j > midIndex; j--) {
                rightSum += numbers[j];
            }

            if (leftSum == rightSum) {
                System.out.println(midIndex);
                return;
            }
        }

        System.out.println("no");
    }
}
