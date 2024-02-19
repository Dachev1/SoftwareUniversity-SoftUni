package ExamPreparation.June_26_2021.GroomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }

        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet petToReturn = null;

        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                petToReturn = pet;
                return petToReturn;
            }
        }

        return petToReturn;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("The grooming salon has the following clients:");
        sb.append(System.lineSeparator());

        for (Pet pet : this.data) {
            sb.append(String.format("%s %s", pet.getName(), pet.getOwner()));
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
