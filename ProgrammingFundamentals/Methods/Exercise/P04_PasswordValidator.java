package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPassword = scanner.nextLine();

        passValidator(inputPassword);
    }

    public static void passValidator(String pass) {

        boolean length = false;
        boolean lettersDigits = true;
        boolean digits2 = false;
        int counterDigits = 0;

        if (pass.length() >= 6 && pass.length() <= 12) {
            length = true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
        }

        for (int i = 0; i < pass.length(); i++) {

            char current = pass.charAt(i);

            if ((int) current >= 48 && (int) current <= 57) {
                counterDigits++;
            }

            if ((int) current < 48 || (int) current > 122 ||
                    (int) current > 90 && (int) current < 97 ||
                    (int) current > 57 && (int) current < 65) {
                lettersDigits = false;
            }
        }


        if (!lettersDigits) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (counterDigits < 2) {
            System.out.println("Password must have at least 2 digits");
        } else {
            digits2 = true;
        }

        if (length && lettersDigits && digits2) {
            System.out.println("Password is valid");
        }
    }
}
