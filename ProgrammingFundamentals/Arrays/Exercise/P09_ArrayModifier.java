package ProgrammingFundamentals.Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();


        while (!input.equals("end")) {
            String[] inputArgs = input.split(" ");
            String command = inputArgs[0];

            if (command.equals("swap")) {
                int num1 = Integer.parseInt(inputArgs[1]);
                int num2 = Integer.parseInt(inputArgs[2]);

                int firstNumber = numbers[num1];
                int secondNumber = numbers[num2];

                numbers[num1] = secondNumber;
                numbers[num2] = firstNumber;
            } else if (command.equals("multiply")) {
                int num1 = Integer.parseInt(inputArgs[1]);
                int num2 = Integer.parseInt(inputArgs[2]);

                int firstNumber = numbers[num1];
                int secondNumber = numbers[num2];

                int total = firstNumber * secondNumber;
                numbers[num1] = total;
            } else if (command.equals("decrease")) {
                for (int i = 0; i < numbers.length ; i++) {
                    numbers[i]--;
                }
            }

            input = scanner.nextLine();
        }

        System.out.println(Arrays.toString(numbers)
                .replace("[", "")
                .replace("]", ""));
    }
}
