package ProgrammingFundamentals.MidExamsPractise.Exam4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> neighborhood = Arrays.stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int cupidIdx = 0;
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Love!")) {
                break;
            }

            String command = input.split(" ")[0];

            if (command.equals("Jump")) {
                int length = Integer.parseInt(input.split(" ")[1]);
                cupidIdx += length;

                if (cupidIdx >= neighborhood.size()) {
                    cupidIdx = 0;
                }

                int currentHouseHearths = neighborhood.get(cupidIdx);
                if (currentHouseHearths == 0) {
                    System.out.printf("Place %d already had Valentine's day.\n", cupidIdx);
                    continue;
                }

                int afterCupidGiveHearths = currentHouseHearths - 2;
                neighborhood.set(cupidIdx, afterCupidGiveHearths);

                if (afterCupidGiveHearths <= 0) {
                    System.out.printf("Place %d has Valentine's day.\n", cupidIdx);
                }
            }
        }

        boolean isSuccessful = true;
        int failedHouseCount = 0;
        for (int house : neighborhood) {
            if (house > 0) {
                failedHouseCount++;
                isSuccessful = false;
            }
        }

        System.out.printf("Cupid's last position was %d.\n", cupidIdx);
        if (isSuccessful) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.\n", failedHouseCount);
        }
    }
}
