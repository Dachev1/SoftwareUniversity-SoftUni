package ProgrammingFundamentals.TextProcessing.Exercise;

import java.util.Scanner;

public class P01_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            if(isValidUsername(username)) {
                System.out.println(username);
            }
        }

    }

    private static boolean isValidUsername(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }

        for (char el : username.toCharArray()) {
            if (!Character.isLetterOrDigit(el) && el != '-' && el != '_') {
                return false;
            }
        }

        return true;
    }
}
