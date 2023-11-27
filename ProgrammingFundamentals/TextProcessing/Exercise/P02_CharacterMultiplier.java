package ProgrammingFundamentals.TextProcessing.Exercise;

import java.util.Scanner;

public class P02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        String firstWord = words[0];
        String secondWord = words[1];
        int shortedWord = Math.min(firstWord.length(), secondWord.length());

        int totalSum = 0;
        totalSum = getTotalSum(firstWord, secondWord, shortedWord, totalSum);

        System.out.println(totalSum);
    }

    private static int getTotalSum(String firstWord, String secondWord, int shortedWord, int totalSum) {
        for (int i = 0; i < shortedWord; i++) {
            char el1 = firstWord.charAt(i);
            char el2 = secondWord.charAt(i);

            totalSum += el1 * el2;
        }

        if (firstWord.length() < secondWord.length()) {
            for (int i = shortedWord; i <= secondWord.length() - 1; i++) {
                char el = secondWord.charAt(i);
                totalSum += el;
            }
        } else if (secondWord.length() < firstWord.length()) {
            for (int i = shortedWord; i <= firstWord.length() - 1; i++) {
                char el = firstWord.charAt(i);
                totalSum += el;
            }
        }
        return totalSum;
    }
}
