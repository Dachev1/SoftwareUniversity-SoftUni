package Exercise_September_15.MoreExercise;

import java.util.Scanner;

public class P04_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String reversedText = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            char currentSymbol = text.charAt(i);
            reversedText += currentSymbol;
        }

        System.out.println(reversedText);
    }
}
