package ProgrammingFundamentals.Methods.Lab;

import java.util.Scanner;

public class P11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());

        System.out.println(calculate(a , operation , b));
    }

    public static int calculate(int a, String operation, int b) {
        int total = 0;

        switch (operation) {
            case "+":
                total = a + b;
                break;
            case "-":
                total = a - b;
                break;
            case "*":
                total = a * b;
                break;
            case "/":
                total = a / b;
                break;
        }

        return total;
    }
}
