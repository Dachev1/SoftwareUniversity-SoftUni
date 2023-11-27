package ProgrammingFundamentals.TextProcessing.Lab;

import java.util.Scanner;

public class P02_RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                sb.append(word);
            }
        }

        System.out.println(sb);
    }
}
