package ProgrammingFundamentals.TextProcessing.Exercise;

import java.util.Scanner;

public class P08_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] codes = scanner.nextLine().split("\\s+");

        double totalSum = 0;
        for (String code : codes) {
            double modifiedNumber = getModifiedNumber(code);

            totalSum += modifiedNumber;
        }

        System.out.printf("%.2f", totalSum);
    }

    private static double getModifiedNumber(String code) {
        char letterBefore = code.charAt(0);
        char letterAfter = code.charAt(code.length() - 1);
        double number = Double.parseDouble(code.replace(letterBefore, ' ')
                .replace(letterAfter, ' ')
                .trim());

        if (Character.isUpperCase(letterBefore)) {
            int positionUpperLetter = (int) letterBefore - 64;
            number /= positionUpperLetter;
        } else {
            int positionUpperLetter = (int) letterBefore - 96;
            number *= positionUpperLetter;
        }

        if (Character.isUpperCase(letterAfter)) {
            int positionUpperLetter = (int) letterAfter - 64;
            number -= positionUpperLetter;
        } else  {
            int positionUpperLetter = (int) letterAfter - 96;
            number += positionUpperLetter;
        }

        return number;
    }
}
