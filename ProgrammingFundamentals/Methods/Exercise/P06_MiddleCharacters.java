package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        if ((text.length() - 1) % 2 == 0) {
            ifEven(text);
        } else {
            ifOdd(text);
        }

    }

    public static void ifEven (String text) {
        int middleCharIndex = text.length() / 2;
        char middleIndex = text.charAt(middleCharIndex);

        System.out.println(middleIndex);
    }

    public static void ifOdd (String text) {
        int middleCharIndex = text.length() / 2;
        char firstMiddleIndex = text.charAt(middleCharIndex - 1);
        char secondMiddleIndex = text.charAt(middleCharIndex);

        System.out.print(firstMiddleIndex);
        System.out.print(secondMiddleIndex);
    }
}
