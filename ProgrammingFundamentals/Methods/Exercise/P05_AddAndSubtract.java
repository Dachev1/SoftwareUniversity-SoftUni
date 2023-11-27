package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        calculate(firstNumber, secondNumber, thirdNumber);
    }

    public static void calculate(int n1, int n2, int n3) {
        System.out.println((n1 + n2) - n3);
    }
}
