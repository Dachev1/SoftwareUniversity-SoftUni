package ExamPreparation.February_19_2022.Parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                this.data.remove(parrot);
                return true;
            }
        }

        return false;
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot;
            }
        }

        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> sellParrots = new ArrayList<>();

        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                sellParrots.add(parrot);
            }
        }

        return sellParrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("ExamPreparation.February_19_2022.Parrots available at %s:", this.name));
        builder.append(System.lineSeparator());

        for (Parrot parrot : this.data) {
            if (parrot.isAvailable()) {
                builder.append(parrot);
                builder.append(System.lineSeparator());
            }
        }

        return builder.toString();
    }
}
