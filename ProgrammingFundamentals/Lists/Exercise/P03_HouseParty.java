package ProgrammingFundamentals.Lists.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> peopleList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String name = command.split(" ")[0];

            if (command.contains("not")) {
                if (peopleList.contains(name)) {
                    peopleList.remove(name);
                } else {
                    System.out.println(name + " is not in the list!");
                }
            } else {
                if (peopleList.contains(name)) {
                    System.out.println(name + " is already in the list!");
                } else {
                    peopleList.add(name);
                }
            }
        }

        for (String name : peopleList) {
            System.out.println(name);
        }
    }
}
