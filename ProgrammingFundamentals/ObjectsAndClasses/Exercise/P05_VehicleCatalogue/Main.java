package ProgrammingFundamentals.ObjectsAndClasses.Exercise.P05_VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        int allCarsHorsePowers = 0;
        int carsCount = 0;

        int allTruckHorsePowers = 0;
        int truckCount = 0;
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("End")) {
                break;
            }

            String type = input.split(" ")[0];
            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            int horsePower = Integer.parseInt(input.split(" ")[3]);

            if (type.equals("car")) {
                allCarsHorsePowers += horsePower;
                carsCount++;
            } else if (type.equals("truck")) {
                allTruckHorsePowers += horsePower;
                truckCount++;
            }

            Vehicle vehicle = new Vehicle(type, model, color , horsePower);
            vehicles.add(vehicle);
        }

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Close the Catalogue")) {
                double averageCarHorsePower = (allCarsHorsePowers * 1.0) / carsCount;
                double averageTruckHorsePower = (allTruckHorsePowers * 1.0) / truckCount;

                if (Double.isNaN(averageCarHorsePower)) {
                    averageCarHorsePower = 0;
                }

                if (Double.isNaN(averageTruckHorsePower)) {
                    averageTruckHorsePower =  0;
                }

                System.out.printf("Cars have average horsepower of: %.2f.\n", averageCarHorsePower);
                System.out.printf("Trucks have average horsepower of: %.2f.\n", averageTruckHorsePower);
                break;
            }

            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(input)) {
                    System.out.printf("Type: %s\n", vehicle.getType().toUpperCase().charAt(0) + vehicle.getType().substring(1));
                    System.out.printf("Model: %s\n", vehicle.getModel());
                    System.out.printf("Color: %s\n", vehicle.getColor());
                    System.out.printf("Horsepower: %d\n", vehicle.getHorsePower());
                }
            }
        }
    }
}
