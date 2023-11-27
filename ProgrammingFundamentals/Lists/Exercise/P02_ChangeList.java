package ProgrammingFundamentals.Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputArgs = input.split(" ");

            String command = inputArgs[0];
            //Delete {element} - delete all elements in the array which are equal to the given element
            //Insert {element} {position} - insert element at the given position
            switch (command) {
                case "Insert":
                    int element = Integer.parseInt(inputArgs[1]);
                    int index = Integer.parseInt(inputArgs[2]);

                    numbers.add(index, element);
                    break;

                case "Delete":
                    int elementToRemove = Integer.parseInt(inputArgs[1]);
                    numbers.removeAll(Arrays.asList(elementToRemove));
                    break;
            }



            input = scanner.nextLine();
        }

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
