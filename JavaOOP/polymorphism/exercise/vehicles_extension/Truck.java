package polymorphism.exercise.vehicles.vehicles_extension;

public class Truck extends VehicleImpl {
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        setFuelConsumption(getFuelConsumption() + 1.6);
    }

    @Override
    public String driving(double distance) {
        return super.driving(distance);
    }

    @Override
    public void refueling(double liters) {
        super.refueling(liters * 0.95);
    }
}
