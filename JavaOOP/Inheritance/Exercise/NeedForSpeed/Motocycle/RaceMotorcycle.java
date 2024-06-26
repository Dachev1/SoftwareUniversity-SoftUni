package Inheritance.Exercise.NeedForSpeed.Motocycle;

public class RaceMotorcycle extends Motorcycle {
    public static final double DEFAULT_FUEL_CONSUMPTION = 8;

    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
