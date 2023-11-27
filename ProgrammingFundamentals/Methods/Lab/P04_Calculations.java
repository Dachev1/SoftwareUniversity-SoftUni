package ProgrammingFundamentals.Methods.Lab;

import java.util.Scanner;

public class P04_Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        System.out.println(sumNumbers(command,number1, number2));

    }

    public static int sumNumbers(String command, int a, int b) {
        int sum = 0;
        switch (command) {
            case "add":
                sum = a + b;
                break;
            case "multiply":
                sum = a * b;
                break;
            case "subtract":
                sum = a - b;
                break;
            case "divide":
                sum = a / b;
                break;
        }

        return sum;
    }
}
