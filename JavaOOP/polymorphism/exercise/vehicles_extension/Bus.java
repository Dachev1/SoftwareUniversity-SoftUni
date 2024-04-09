package polymorphism.exercise.vehicles.vehicles_extension;

public class Bus extends VehicleImpl{
    private static final boolean EMPTY = true;
    private boolean isEmpty;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = EMPTY;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String driving(double distance) {
        if (this.isEmpty) {
            setFuelConsumption(getFuelConsumption() - 1.4);
        }

        if (!this.isEmpty) {
            setFuelConsumption(getFuelConsumption() + 1.4);
        }

        return super.driving(distance);
    }
}
