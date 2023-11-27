package ProgrammingFundamentals.RegularMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> friendsList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        int blackListedCount = 0;
        int lostNamesCount = 0;
        while (true) {
            String line = scanner.nextLine();

            if (line.equals("Report")) {
                break;
            }

            String command = line.split(" ")[0];

            if (command.equals("Blacklist")) {
                String name = line.split(" ")[1];
                int idxOfName = friendsList.indexOf(name);

                if (friendsList.contains(name)) {
                    friendsList.set(idxOfName, "Blacklisted");
                    System.out.printf("%s was blacklisted.\n", name);
                    blackListedCount++;
                } else {
                    System.out.printf("%s was not found.\n", name);
                }
            } else if (command.equals("Error")) {
                int idx = Integer.parseInt(line.split(" ")[1]);

                if (isValidIdx(friendsList, idx)) {
                    String nameOfIdx = friendsList.get(idx);

                    if (!(nameOfIdx.equals("Blacklisted"))) {
                        if (!(nameOfIdx.equals("Lost"))) {
                            System.out.printf("%s was lost due to an error.\n", nameOfIdx);
                            friendsList.set(idx, "Lost");
                            lostNamesCount++;
                        }
                    }
                }
            } else if (command.equals("Change")) {
                int idx = Integer.parseInt(line.split(" ")[1]);
                String newName = line.split(" ")[2];

                if (isValidIdx(friendsList, idx)) {
                    String currentName = friendsList.get(idx);
                    friendsList.set(idx, newName);

                    System.out.printf("%s changed his username to %s.\n", currentName, newName);
                }
            }
        }

        System.out.printf("Blacklisted names: %d\n", blackListedCount);
        System.out.printf("Lost names: %d\n", lostNamesCount);

        for (String name : friendsList) {
            System.out.print(name + " ");
        }
    }

    private static boolean isValidIdx(List<String> friendsList, int idx) {
        return idx >= 0 && idx <= friendsList.size() - 1;
    }
}
