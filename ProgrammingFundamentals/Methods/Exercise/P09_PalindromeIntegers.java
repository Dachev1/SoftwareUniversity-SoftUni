package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            int number = Integer.parseInt(input);

            if (isPalindrome(number)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            input = scanner.nextLine();
        }
    }

    public static boolean isPalindrome(int number) {
        int startNumber = number;
        int reverseNumber = 0;
        while (number > 0) {
           int rem = number % 10;
            reverseNumber = (reverseNumber * 10) + rem;
            number = number / 10;
        }

        if (reverseNumber == startNumber) {
            return true;
     } else {
            return false;
        }
    }
}
