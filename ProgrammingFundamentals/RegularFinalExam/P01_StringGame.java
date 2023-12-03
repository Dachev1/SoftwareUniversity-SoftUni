package ProgrammingFundamentals.RegularFinalExam;

import java.util.Scanner;

public class P01_StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String input;
        while (!"Done".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            if (command.equals("Change")) {
                char oldChr = tokens[1].charAt(0);
                char replacement = tokens[2].charAt(0);
                str = str.replace(oldChr, replacement);

                System.out.println(str);
            } else if (command.equals("Includes")) {
                String substring = tokens[1];

                if (str.contains(substring)) {
                    System.out.println("True");
                } else  {
                    System.out.println("False");
                }
            } else if (command.equals("End")) {
                String substring = tokens[1];

                if (str.endsWith(substring)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if (command.equals("Uppercase")) {
                str = str.toUpperCase();

                System.out.println(str);
            } else if (command.equals("FindIndex")) {
                char chr = tokens[1].charAt(0);
                System.out.println(str.indexOf(chr));
            } else if (command.equals("Cut")) {
                int startIdx = Integer.parseInt(tokens[1]);
                int count = Integer.parseInt(tokens[2]);

                int endIdx = startIdx + count;
                    if (endIdx > startIdx) {
                        str = str.substring(startIdx, endIdx);
                        System.out.println(str);
                    }
            }
        }
    }
}
