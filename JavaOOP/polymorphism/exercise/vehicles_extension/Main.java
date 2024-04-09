package polymorphism.exercise.vehicles.vehicles_extension;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carTokens = scanner.nextLine().split("\\s+");
        String[] truckTokens = scanner.nextLine().split("\\s+");
        String[] busTokens = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Double.parseDouble(carTokens[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]), Double.parseDouble(truckTokens[3]));
        Vehicle bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]), Double.parseDouble(busTokens[3]));

        Map<String, Vehicle> vehicleMap = Map.of("Car", car, "Truck", truck, "Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());


            for (int i = 0; i < n; i++) {
                try {
                String[] commandTokens = scanner.nextLine().split("\\s+");

                switch (commandTokens[0]) {
                    case "Drive":
                        if (vehicleMap.get(commandTokens[1]) instanceof Bus) {
                            ((Bus) bus).setEmpty(false);
                        }
                        System.out.println(vehicleMap.get(commandTokens[1]).driving(Double.parseDouble(commandTokens[2])));
                        break;
                    case "DriveEmpty":
                        if (vehicleMap.get(commandTokens[1]) instanceof Bus) {
                            ((Bus) bus).setEmpty(true);
                        }
                        System.out.println(vehicleMap.get(commandTokens[1]).driving(Double.parseDouble(commandTokens[2])));
                        break;
                    case "Refuel":
                        vehicleMap.get(commandTokens[1]).refueling(Double.parseDouble(commandTokens[2]));
                        break;
                }
            } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
