package ProgrammingFundamentals.FinalExamPractise.Exam3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class P03_NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Integer>> carDataMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\|");
            String car = line[0];
            int mileage = Integer.parseInt(line[1]);
            int fuel = Integer.parseInt(line[2]);

            carDataMap.put(car, new ArrayList<>());
            carDataMap.get(car).add(mileage);
            carDataMap.get(car).add(fuel);
        }

        String line;
        while (!"Stop".equals(line = scanner.nextLine())) {
            String[] lineArgs = line.split(" : ");
            String command = lineArgs[0];
            String car = lineArgs[1];

            if (command.equals("Drive")) {
                int distance = Integer.parseInt(lineArgs[2]);
                int fuel = Integer.parseInt(lineArgs[3]);

                if (fuel > carDataMap.get(car).get(1)) {
                    System.out.println("Not enough fuel to make that ride");
                } else {
                    int newMileage = carDataMap.get(car).get(0) + distance;
                    carDataMap.get(car).remove(0);
                    carDataMap.get(car).add(0, newMileage);

                    int newFuel = carDataMap.get(car).get(1) - fuel;
                    carDataMap.get(car).remove(1);
                    carDataMap.get(car).add(1, newFuel);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", car, distance , fuel);

                    if (carDataMap.get(car).get(0) >= 100_000) {
                        System.out.printf("Time to sell the %s!\n", car);
                        carDataMap.remove(car);
                    }
                }
            } else if (command.equals("Refuel")) {
                int fuel = Integer.parseInt(lineArgs[2]);

                int refill = 0;
                refill = Math.min(carDataMap.get(car).get(1) + fuel, 75);
                int beforeRefill = carDataMap.get(car).get(1);


                carDataMap.get(car).remove(1);
                carDataMap.get(car).add(1, refill);
                System.out.printf("%s refueled with %d liters\n", car, refill - beforeRefill);

            } else if (command.equals("Revert")) {
                int kilometers = Integer.parseInt(lineArgs[2]);
                int afterDecreaseMileage = carDataMap.get(car).get(0) - kilometers;

                if (afterDecreaseMileage < 10_000) {
                    carDataMap.get(car).remove(0);
                    carDataMap.get(car).add(0, 10_000);
                } else {
                    carDataMap.get(car).remove(0);
                    carDataMap.get(car).add(0, afterDecreaseMileage);
                    System.out.printf("%s mileage decreased by %d kilometers\n", car, kilometers);
                }
            }
        }

        carDataMap.forEach((k, v) -> {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n", k, v.get(0), v.get(1));
        });
    }
}
