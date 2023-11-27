package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();

        vowels(text);
    }

    public static void vowels(String text) {
        int vowelsCount = 0;
        for (char currentLetter : text.toCharArray()) {
             if (
                 currentLetter == 'a' ||
                 currentLetter == 'e' ||
                 currentLetter == 'i' ||
                 currentLetter == 'o' ||
                 currentLetter == 'u') {
                 vowelsCount++;
             }
        }

        System.out.println(vowelsCount);
    }
}
