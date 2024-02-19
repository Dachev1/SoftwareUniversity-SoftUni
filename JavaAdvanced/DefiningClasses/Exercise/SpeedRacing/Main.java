package DefiningClasses.Exercise.SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPer1Kilometer = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostPer1Kilometer, 0);
            cars.add(car);
        }

        System.out.println();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");

            String command = tokens[0];
            String carModel = tokens[1];
            int amountOfKilometers = Integer.parseInt(tokens[2]);

            if (command.equals("Drive")) {
                for (Car car : cars) {
                    if (car.getModel().equals(carModel)) {
                        car.Drive(amountOfKilometers);
                    }
                }
            }
        }

        cars.forEach(System.out::println);
    }
}
