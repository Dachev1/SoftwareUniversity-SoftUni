package polymorphism.exercise.vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    private double fuelQuantity;
    private double fuelConsumption;


    public VehicleImpl(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String driving(double distance) {
        String result;
        double neededFuel = this.fuelConsumption * distance;

        if (this.fuelQuantity >= neededFuel) {
            this.fuelQuantity -= neededFuel;


            result = String.format("%s travelled %s km", getClass().getSimpleName(), this.DECIMAL_FORMAT.format(distance));
        } else {
            result = String.format("%s needs refueling", getClass().getSimpleName());
        }
        return result;
    }

    @Override
    public void refueling(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                getClass().getSimpleName(), this.fuelQuantity);
    }
}
