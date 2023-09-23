package ProgrammingFundamentals.DataTypesAndVariables.Exercise.MoreExercise;

import java.util.Scanner;

public class P06_BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int openingBracketsCount = 0;
        int closingBracketsCount = 0;

        for (int i = 1; i <= n ; i++) {
            String input = scanner.nextLine();

            if (input.equals("(")) {
                openingBracketsCount++;
            } else if (input.equals(")")) {
                closingBracketsCount++;

                if (openingBracketsCount - closingBracketsCount != 0) {
                    System.out.println("UNBALANCED");;
                    return;
                }
            }
        }

        if (openingBracketsCount == closingBracketsCount) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}

