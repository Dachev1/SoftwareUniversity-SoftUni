package ProgrammingFundamentals.TextProcessing.Exercise.MoreExercises;

import java.util.Scanner;

public class P02_AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char startChr = scanner.nextLine().charAt(0);
        char endChr = scanner.nextLine().charAt(0);
        String input = scanner.nextLine();

        int totalSum = 0;

        for (char el : input.toCharArray()) {
            if (el > startChr && el < endChr) {
                totalSum += el;
            }
        }

        System.out.println(totalSum);
    }
}
