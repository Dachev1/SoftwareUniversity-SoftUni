package ProgrammingFundamentals.MidExamsPractise.Exam5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String command = input.split(" ")[0];
            if (command.equals("swap")) {
                int idx1 = Integer.parseInt(input.split(" ")[1]);
                int idx2 = Integer.parseInt(input.split(" ")[2]);

                int idx1Number = numbers.get(idx1);
                int idx2Number = numbers.get(idx2);

                numbers.set(idx1, idx2Number);
                numbers.set(idx2, idx1Number);

            } else if (command.equals("multiply")) {
                int idx1 = Integer.parseInt(input.split(" ")[1]);
                int idx2 = Integer.parseInt(input.split(" ")[2]);

                int idx1Number = numbers.get(idx1);
                int idx2Number = numbers.get(idx2);

                numbers.set(idx1, idx1Number * idx2Number);

            } else if (command.equals("decrease")) {
                for (int i = 0; i < numbers.size(); i++) {
                    int currentNumber = numbers.get(i);
                    numbers.set(i,currentNumber - 1);
                }
            }
        }

        System.out.println(String.format(String.valueOf(numbers))
                .replace("[", "")
                .replace("]", ""));
    }
}
