package Inheritance.Exercise.NeedForSpeed.Car;

import Inheritance.Exercise.NeedForSpeed.Vehicle;

public class Car extends Vehicle {
    public static final double DEFAULT_FUEL_CONSUMPTION = 3;
    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
