package ProgrammingFundamentals.FinalExamPractise.Exam5;

import java.util.Locale;
import java.util.Scanner;

public class P01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder key = new StringBuilder(scanner.nextLine());
        String rawKey = key.toString();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("Generate")) {
                break;
            }

            String[] data = line.split(">>>");
            String command = data[0];

            if (command.equals("Contains")) {
                String substring = data[1];
                if (key.toString().contains(substring)) {
                    System.out.printf("%s contains %s\n", key, substring);
                } else {
                    System.out.println("Substring not found!");
                }
                continue;
            } else if (command.equals("Flip")) {
                String upperOrLower = data[1];
                int startIdx = Integer.parseInt(data[2]);
                int endIdx = Integer.parseInt(data[3]);

                String substring = "";
                for (int i = startIdx; i < endIdx; i++) {
                    substring += key.charAt(i);
                }

                if (upperOrLower.equals("Upper")) {
                    key.replace(startIdx, endIdx, substring.toUpperCase());

                } else if (upperOrLower.equals("Lower")) {
                    key.replace(startIdx, endIdx, substring.toLowerCase());
                }

            } else if (command.equals("Slice")) {
                int startIdx = Integer.parseInt(data[1]);
                int endIdx = Integer.parseInt(data[2]);

                key.delete(startIdx, endIdx);
            }

            System.out.println(key);
        }

        System.out.println("Your activation key is: " + key);
    }
}
