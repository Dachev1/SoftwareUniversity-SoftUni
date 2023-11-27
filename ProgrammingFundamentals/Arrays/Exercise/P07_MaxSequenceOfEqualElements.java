package ProgrammingFundamentals.Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] seq = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int length = 1;
        int maxLength = 0;
        int startIndex = 0;
        int bestStartIndex = 0; // правя тази променлива, защото трябва да взема от ляво най-дългата поредица

        for (int i = 1; i <= seq.length - 1; i++) {
            if (seq[i] == seq[i - 1]) {
                length++;
            } else {
                length = 1;
                startIndex = i;
            }

            if (length > maxLength) {
                maxLength = length;
                bestStartIndex = startIndex;
            }
        }

        for (int i = bestStartIndex; i < bestStartIndex + maxLength; i++) {
            System.out.print(seq[i] + " ");
        }
    }
}
