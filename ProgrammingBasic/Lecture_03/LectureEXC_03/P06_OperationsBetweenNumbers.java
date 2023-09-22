package Lecture_03.LectureEXC_03;

import java.util.Scanner;

public class P06_OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        switch (operator) {
            case "+":
                int sum = number1 + number2;
                if (sum % 2 == 0) {
                    System.out.printf("%d + %d = %d - even", number1, number2, sum);
                } else {
                    System.out.printf("%d + %d = %d - odd", number1, number2, sum);
                }
                break;

            case "-":
                int min = number1 - number2;
                if (min % 2 == 0) {
                    System.out.printf("%d - %d = %d - even", number1, number2, min);
                } else {
                    System.out.printf("%d - %d = %d - odd", number1, number2, min);
                }
                break;

            case "*":
                int rezult = number1 * number2;
                if (rezult % 2 == 0) {
                    System.out.printf("%d * %d = %d - even", number1, number2, rezult);
                } else {
                    System.out.printf("%d * %d = %d - odd", number1, number2, rezult);
                }
                break;

            case "/":
                double devide = number1 * 1.0 / number2;
                if (number2 == 0) {
                    System.out.printf("Cannot divide %d by zero", number1);
                } else {
                    System.out.printf("%d / %d = %.2f", number1, number2, devide);
                }
                break;


            case "%":

                if (number2 == 0) {
                    System.out.printf("Cannot divide %d by zero", number1);
                } else {
                    int percent = number1 % number2;
                    System.out.printf("%d %% %d = %d", number1, number2, percent);
                }
                break;
        }
    }
}
