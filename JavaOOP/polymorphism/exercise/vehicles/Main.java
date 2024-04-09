package polymorphism.exercise.vehicles;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carTokens = scanner.nextLine().split("\\s+");
        String[] truckTokens = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        Map<String, Vehicle> vehicleMap = Map.of("Car", car, "Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandTokens = scanner.nextLine().split("\\s+");

            switch (commandTokens[0]) {
                case "Drive":
                    System.out.println(vehicleMap.get(commandTokens[1]).driving(Double.parseDouble(commandTokens[2])));
                    break;
                case "Refuel":
                    vehicleMap.get(commandTokens[1]).refueling(Double.parseDouble(commandTokens[2]));
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
