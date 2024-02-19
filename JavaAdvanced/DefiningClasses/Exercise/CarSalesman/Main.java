package DefiningClasses.Exercise.CarSalesman;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int enginesCounts = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> enginesMap = new HashMap<>();

        while (enginesCounts-- > 0) {
            String[] engineInfo = scanner.nextLine().split("\\s+");

            Engine engine;

            String model = engineInfo[0];
            int power = Integer.parseInt(engineInfo[1]);

            switch (engineInfo.length) {
                case 3:
                    if (engineInfo[2].matches("\\d+")) {
                        int displacement = Integer.parseInt(engineInfo[2]);

                        engine = new Engine(model, power, displacement);
                    } else {
                        String efficiency = engineInfo[2];

                        engine = new Engine(model, power, efficiency);
                    }
                    break;

                case 4:
                    engine = new Engine(model, power, Integer.parseInt(engineInfo[2]), engineInfo[3]);
                    break;
                default:
                    engine = new Engine(model, power);
                    break;
            }

            enginesMap.put(model, engine);
        }

        int carsCount = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (carsCount-- > 0) {
            String[] carInfo = scanner.nextLine().split("\\s+");

            Car car;

            String model = carInfo[0];
            String engine = carInfo[1];

            switch (carInfo.length) {
                case 3:
                    if (carInfo[2].matches("\\d+")) {
                        int weight = Integer.parseInt(carInfo[2]);

                        car = new Car(model, enginesMap.get(engine), weight);
                    } else {
                        String color = carInfo[2];

                        car = new Car(model, enginesMap.get(engine), color);
                    }
                    break;
                case 4:
                    car = new Car(model, enginesMap.get(engine), Integer.parseInt(carInfo[2]), carInfo[3]);
                    break;
                default:
                    car = new Car(model, enginesMap.get(engine));
                    break;
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
