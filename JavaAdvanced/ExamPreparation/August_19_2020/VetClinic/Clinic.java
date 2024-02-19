package ExamPreparation.August_19_2020.VetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
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
    public Pet getOldestPet() {
        return this.data.stream().max(Comparator.comparing(Pet::getAge)).orElse(null);
    }
    public Pet getPet(String name, String owner) {
        Pet pet = null;

        for (Pet currentPet : this.data) {
            if (currentPet.getName().equals(name) && currentPet.getOwner().equals(owner)) {
                pet = currentPet;
                break;
            }
        }

        return pet;
    }

    public int getCount() {
        return this.data.size();
    }

   public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("The clinic has the following patients:");
        sb.append(System.lineSeparator());

       for (Pet pet : this.data) {
           sb.append(String.format("%s %s", pet.getName(), pet.getOwner()));
           sb.append(System.lineSeparator());
       }

        return sb.toString().trim();
   }
}

