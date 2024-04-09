package polymorphism.exercise.vehicles;

public class Truck extends  VehicleImpl{
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
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
