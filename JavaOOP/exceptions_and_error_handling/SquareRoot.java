package exceptions_and_error_handling;

import java.util.Scanner;

public class SquareRoot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number >= 0) {
                System.out.printf("%.2f\n", Math.sqrt(number));
            } else {
                System.out.println("Invalid");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
