package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        findTheSmallestNumber(firstNumber, secondNumber, thirdNumber);
    }

    public static void findTheSmallestNumber(int n1, int n2, int n3) {
        System.out.println(Math.min(Math.min(n1, n2), n3));
    }
}
