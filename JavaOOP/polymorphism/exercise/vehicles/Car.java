package polymorphism.exercise.vehicles;

public class Car extends VehicleImpl{
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        setFuelConsumption(getFuelConsumption() + 0.9);
    }

    @Override
    public String driving(double distance) {
        return super.driving(distance);
    }
}
