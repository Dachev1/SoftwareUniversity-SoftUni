package ProgrammingFundamentals.MidExamsPractise.Exam2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("Craft!")) {
                break;
            }

            String command = line.split(" - ")[0];

            if (command.equals("Collect")) {
                String itemToAdd = line.split(" - ")[1];

                if (!(items.contains(itemToAdd))) {
                    items.add(itemToAdd);
                }
            } else if (command.equals("Drop")) {
                String itemToRemove = line.split(" - ")[1];

                items.remove(itemToRemove);
                System.out.println();
            } else if (command.equals("Combine Items")) {
                String oldNewItems = line.split(" - ")[1];

                String oldItem = oldNewItems.split(":")[0];
                String newItem = oldNewItems.split(":")[1];

                if (items.contains(oldItem)) {
                    int idxOfOldItem = items.indexOf(oldItem);
                    items.add(idxOfOldItem + 1, newItem);
                }
            } else if (command.equals("Renew")) {
                String itemToRenew = line.split(" - ")[1];
                if (items.contains(itemToRenew)) {
                    int idx = items.indexOf(itemToRenew);

                    items.remove(idx);
                    items.add(itemToRenew);
                }
            }
        }

        System.out.println(String.format(items.toString())
                .replace("[", "")
                .replace("]", ""));
    }
}
