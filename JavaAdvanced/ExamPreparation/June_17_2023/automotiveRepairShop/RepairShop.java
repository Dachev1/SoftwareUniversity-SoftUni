package ExamPreparation.June_17_2023.automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {

    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles.size() < this.capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getVIN().equals(vin)) {
                vehicleToRemove = vehicle;
               break;
            }
        }

        return vehicles.remove(vehicleToRemove);
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        Vehicle theLowestMileageVehicle = null;
        int mileage = Integer.MAX_VALUE;

        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getMileage() < mileage) {
                theLowestMileageVehicle = vehicle;
                mileage = vehicle.getMileage();
            }
        }

        return theLowestMileageVehicle;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:");
        sb.append(System.lineSeparator());

        for (Vehicle v : vehicles) {
            sb.append(v.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
