package ProgrammingFundamentals.TextProcessing.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWord = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : bannedWord) {
            String replacement = getReplacement(word);
            text = text.replace(word, replacement);
        }

        System.out.println(text);
    }

    private static String getReplacement(String word) {
        char[] replacementCharArr = new char[word.length()];

        Arrays.fill(replacementCharArr, '*');

        return new String(replacementCharArr);
    }


}
