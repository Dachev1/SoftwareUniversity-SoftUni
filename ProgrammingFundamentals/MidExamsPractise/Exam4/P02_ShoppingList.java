package ProgrammingFundamentals.MidExamsPractise.Exam4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceries = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());


        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Go Shopping!")) {
                break;
            }

            String command = input.split(" ")[0];

            if (command.equals("Urgent")) {
                String item = input.split(" ")[1];

                if (!groceries.contains(item)) {
                    groceries.add(0, item);
                }
            } else if (command.equals("Unnecessary")) {
                String item = input.split(" ")[1];
                groceries.remove(item);
            } else if (command.equals("Correct")) {
                String oldItem = input.split(" ")[1];
                String newItem = input.split(" ")[2];

                if (groceries.contains(oldItem)) {
                    int idxOfOltItem = groceries.indexOf(oldItem);
                    groceries.set(idxOfOltItem, newItem);
                }
            } else if (command.equals("Rearrange")) {
                String item = input.split(" ")[1];

                if (groceries.contains(item)) {
                    groceries.remove(item);
                    groceries.add(item);
                }
            }
        }

        System.out.println(String.format(String.valueOf(groceries))
                .replace("[", "")
                .replace("]", ""));
    }
}
