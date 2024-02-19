package ExamPreparation.February_20_2021.CarDealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }

        return false;
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        Car car = null;

        for (Car currentCar : this.data) {
            if (currentCar.getManufacturer().equals(manufacturer) && currentCar.getModel().equals(model)) {
                car = currentCar;
                break;
            }
        }

        return car;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The cars are in a car dealership %s:", this.name));
        sb.append(System.lineSeparator());

        this.data.forEach(car -> sb.append(car).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
