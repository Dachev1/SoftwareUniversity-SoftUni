package ProgrammingFundamentals.Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr1 = Arrays.stream(scanner.nextLine()
                .split(" ")).
                mapToInt(Integer::parseInt)
                .toArray();

        int[] numbersArr2 = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        for (int i = 0; i < numbersArr1.length; i++) {
            int currentNumArr1 = numbersArr1[i];
            int currentNumArr2 = numbersArr2[i];

            if (currentNumArr1 != currentNumArr2) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                return;
            } else {
                sum += currentNumArr1;
            }
        }

        System.out.printf("Arrays are identical. Sum: %d", sum);
    }
}
