package ProgrammingFundamentals.Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] seq1 = new int[n];
        int[] seq2 = new int[n];

        for (int i = 0; i < n; i++) {
            String[] inputArgs = scanner.nextLine().split(" ");
            int num1 = Integer.parseInt(inputArgs[0]);
            int num2 = Integer.parseInt(inputArgs[1]);

            if (i % 2 != 0) {
                seq1[i] = num1;
                seq2[i] = num2;
            } else {
                seq1[i] = num2;
                seq2[i] = num1;
            }
        }

        System.out.println(Arrays.toString(seq2)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));

        System.out.println(Arrays.toString(seq1)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}
