package polymorphism.exercise.vehicles.vehicles_extension;

public class Car extends VehicleImpl {
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        setFuelConsumption(getFuelConsumption() + 0.9);
    }

    @Override
    public String driving(double distance) {
        return super.driving(distance);
    }
}
