package ProgrammingFundamentals.TextProcessing.Lab;

import java.util.Scanner;

public class P01_ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = scanner.nextLine();

            if (word.equals("end")) {
                break;
            }

            String reversedWord = reversed(word);
            System.out.printf("%s = %s%n", word, reversedWord);
        }
    }

    private static String reversed(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = word.length() - 1; i >= 0 ; i--) {
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }
}
