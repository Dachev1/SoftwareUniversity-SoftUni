package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        double division = factOfNumber(firstNumber) * 1.0 / factOfNumber(secondNumber);

        System.out.printf("%.2f", division);
    }

    public static long factOfNumber(int num) {
        long fact = 1;

        for (int i = 1; i <= num; i++) {
            fact *= i;
        }

        return fact;
    }
}
