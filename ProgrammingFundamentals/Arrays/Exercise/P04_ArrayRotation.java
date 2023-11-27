package ProgrammingFundamentals.Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequence = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String firstEl = sequence[0];
            for (int j = 0; j < sequence.length - 1; j++) {
                sequence[j] = sequence[j + 1];
            }
            sequence[sequence.length - 1] = firstEl;
        }

        System.out.println(Arrays.toString(sequence)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));


    }
}
