package ProgrammingFundamentals.TextProcessing.Lab;

import java.util.Scanner;

public class P03_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String text = scanner.nextLine();

        while (text.contains(word)) {
            text = text.replace(word, "");
        }

        System.out.println(text);
    }
}
