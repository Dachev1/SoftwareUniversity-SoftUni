package ProgrammingFundamentals.FinalExamPractise;

import java.util.Scanner;

public class P01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encryptedMessage = new StringBuilder(scanner.nextLine());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Decode")) {
                break;
            }

            String[] inputArgs = input.split("\\|");
            String command = inputArgs[0];

            if (command.equals("Move")) {
                int numberOfLetters = Integer.parseInt(inputArgs[1]);
                String nLetters = encryptedMessage.substring(0, numberOfLetters);
                encryptedMessage.delete(0, numberOfLetters);
                encryptedMessage.append(nLetters);

            } else if (command.equals("Insert")) {
                int idx = Integer.parseInt(inputArgs[1]);
                String value = inputArgs[2];
                encryptedMessage.insert(idx, value);

            } else if (command.equals("ChangeAll")) {
                String substring = inputArgs[1];
                String replacement = inputArgs[2];

                String changedMsg = encryptedMessage.toString().replace(substring,replacement);
                encryptedMessage = new StringBuilder(changedMsg);
            }
        }

        System.out.printf("The decrypted message is: %s\n", encryptedMessage);
    }
}
