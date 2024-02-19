package DefiningClasses.Exercise.SpeedRacing;

public class Car {

    private String model;
    private double amountFuel;
    private double fuelCostPer1Kilometer;
    private int distanceTraveled;

    public Car(String model, double amountFuel, double fuelCostPer1Kilometer, int distanceTraveled) {
        this.model = model;
        this.amountFuel = amountFuel;
        this.fuelCostPer1Kilometer = fuelCostPer1Kilometer;
        this.distanceTraveled = distanceTraveled;
    }

    public String getModel() {
        return model;
    }

    public double getAmountFuel() {
        return amountFuel;
    }

    public double getFuelCostPer1Kilometer() {
        return fuelCostPer1Kilometer;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void Drive(int kilometers) {
        double neededFuel = kilometers * fuelCostPer1Kilometer;

        if (this.amountFuel >= neededFuel) {
            this.amountFuel -= neededFuel;
            this.distanceTraveled += kilometers;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", getModel(), getAmountFuel(), getDistanceTraveled());
    }
}
