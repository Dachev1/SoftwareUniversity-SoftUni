package ProgrammingFundamentals.FinalExamPractise.Exam3;

import java.util.Scanner;

public class P01_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String line;
        while (!"Reveal".equals(line = scanner.nextLine())) {
            String[] data = line.split(":\\|:");
            String command = data[0];

            if (command.equals("InsertSpace")) {
                int idx = Integer.parseInt(data[1]);
                message.insert(idx, ' ');

                System.out.println(message);
            } else if (command.equals("Reverse")) {
                String substring = data[1];
                String msg = message.toString();
                if (msg.contains(substring)) {
                    deleteAndReversedSubstring(message, substring, msg);
                    System.out.println(message);
                } else {
                    System.out.println("error");
                }
            } else if (command.equals("ChangeAll")) {
                String substring = data[1];
                String replacement = data[2];
                String updatedMsg = message.toString().replace(substring, replacement);
                message = new StringBuilder(updatedMsg);

                System.out.println(message);
            }
        }

        System.out.println("You have a new text message: " + message);
    }

    private static void deleteAndReversedSubstring(StringBuilder message, String substring, String msg) {
        int start = msg.indexOf(substring);
        message.delete(start, start + substring.length());
        StringBuilder reversedText = new StringBuilder(substring);
        reversedText.reverse();

        message.append(reversedText);
    }
}
