package ProgrammingFundamentals.Methods.Lab;

import java.util.Scanner;

public class P07_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatText(text, count));
    }

    public static String repeatText(String text, int count) {
        String resultText = "";

        for (int i = 0; i < count; i++) {
            resultText += text;
        }

        return resultText;
    }
}
