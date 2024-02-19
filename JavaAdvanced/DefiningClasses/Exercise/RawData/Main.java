package DefiningClasses.Exercise.RawData;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Tire[] tires = new Tire[4];
            int tiresCount = 0;

            for (int i = 5; i < tokens.length; i += 2) {
                double tierPressure = Double.parseDouble(tokens[i]);
                int tierAge = Integer.parseInt(tokens[i + 1]);

                tires[tiresCount] = new Tire(tierPressure, tierAge);
                tiresCount++;
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.putIfAbsent(model, car);
        }

        String command = scanner.nextLine();

        for (Car car : cars.values()) {
            if (command.equals("fragile")
                    && "fragile".equals(car.getCargo().getCargoType())
                    && car.hasTierWithLessPressureThanOne()) {
                System.out.println(car.getModel());
            } else if (command.equals("flamable")
                    && "flamable".equals(car.getCargo().getCargoType())
                    && car.getEngine().getEnginePower() > 250) {
                System.out.println(car.getModel());
            }
        }
    }
}
