package ProgrammingFundamentals.Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            if (input.contains("Add")) {
                int wagonToAdd = Integer.parseInt(input.split(" ")[1]);
                wagons.add(wagonToAdd);
            } else {
                int passengers = Integer.parseInt(input.split(" ")[0]);

                for (int i = 0; i <= wagons.size() - 1; i++) {
                    int currentWagonPassengers = wagons.get(i);

                    if (currentWagonPassengers + passengers <= maxCapacity) {
                        wagons.set(i, currentWagonPassengers + passengers );
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
