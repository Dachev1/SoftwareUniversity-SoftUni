package DefiningClasses.Lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        Car car = null;

        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];
            if (tokens.length == 1) {
                car = new Car(brand);
                cars.add(car);
            } else {
                String model = tokens[1];
                int horsepower = Integer.parseInt(tokens[2]);

                car = new Car(brand, model, horsepower);
                cars.add(car);
            }
        }

        cars.forEach(e -> System.out.println(e.carInfo()));
    }
}
