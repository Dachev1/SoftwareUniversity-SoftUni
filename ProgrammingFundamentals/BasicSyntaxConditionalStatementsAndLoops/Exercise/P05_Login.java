package Exercise_September_15;

import java.util.Scanner;

public class P05_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            char currentSymbol = username.charAt(i);
            password += currentSymbol;
        }


        int count = 0;
        String input = scanner.nextLine();

        while (!input.equals(password)) {
            count++;

            if (count == 4) {
                System.out.printf("User %s blocked!", username);
                return;
            }
            System.out.println("Incorrect password. Try again.");

            input = scanner.nextLine();
        }

        System.out.printf("User %s logged in.", username);
    }
}
