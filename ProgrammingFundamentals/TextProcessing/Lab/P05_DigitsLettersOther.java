package ProgrammingFundamentals.TextProcessing.Lab;

import java.util.Scanner;

public class P05_DigitsLettersOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isDigit(ch)) {
                digits.append(ch);
            } else if (Character.isAlphabetic(ch)) {
                letters.append(ch);
            } else {
                others.append(ch);
            }
        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }
}
