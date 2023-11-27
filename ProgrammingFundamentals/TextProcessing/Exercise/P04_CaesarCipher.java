package ProgrammingFundamentals.TextProcessing.Exercise;

import java.util.Scanner;

public class P04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textInput = scanner.nextLine();

        StringBuilder encryptedText = new StringBuilder();

        for (char el : textInput.toCharArray()) {
            char toAdd = (char) (el + 3);
            encryptedText.append(toAdd);
        }

        System.out.println(encryptedText);
    }
}
