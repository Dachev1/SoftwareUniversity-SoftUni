package ProgrammingFundamentals.Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandArgs = input.split(" ");
            String command = commandArgs[0];

            switch (command) {
                case "Add":
                    int numberToAdd = Integer.parseInt(commandArgs[1]);

                    numbers.add(numberToAdd);
                    break;

                case "Remove":
                    int numbersToRemove = Integer.parseInt(commandArgs[1]);

                    numbers.remove(Integer.valueOf(numbersToRemove));
                    break;

                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(commandArgs[1]);

                    numbers.remove(indexToRemove);
                    break;

                case "Insert":
                    int number = Integer.parseInt(commandArgs[1]);
                    int index = Integer.parseInt(commandArgs[2]);

                    numbers.add(index, number);
                    break;
            }

            input = scanner.nextLine();
        }

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
