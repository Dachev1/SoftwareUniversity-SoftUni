package Lecture_05;

import java.util.Scanner;

public class P02_Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();

        String enterPassword = scanner.nextLine();
        while (!enterPassword.equals(password)) {
            enterPassword = scanner.nextLine();
        }

        System.out.printf("Welcome %s!", username);
    }
}
