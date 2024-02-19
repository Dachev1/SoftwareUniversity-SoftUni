package ExamPreparation.August_18_2022.ElephantSanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant elephant : data) {
            if (elephant.getName().equals(name)) {
                this.data.remove(elephant);
                return true;
            }
        }

        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        Elephant elephant = null;

        for (Elephant currentElephant : this.data) {
            if (currentElephant.getRetiredFrom().equals(retiredFrom)) {
                elephant = currentElephant;
                return elephant;
            }
        }

        return elephant;
    }

    public Elephant getOldestElephant() {
        return this.data.stream().max(Comparator.comparing(Elephant::getAge)).orElse(null);
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();

        sb.append("Saved elephants in the park:").append("\n");

        data.forEach(e -> sb.append(
                        String.format("%s came from: %s", e.getName(), e.getRetiredFrom()))
                .append("\n"));

        return sb.toString();
    }
}
