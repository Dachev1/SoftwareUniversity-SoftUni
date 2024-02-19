package ExamPreparation.October_22_2022.AnimalShelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.data.size() < this.capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : this.data) {
            if (animal.getName().equals(name)) {
                this.data.remove(animal);
                return true;
            }
        }

        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        Animal animal = null;

        for (Animal currentAnimal : this.data) {
            if (currentAnimal.getName().equals(name) && currentAnimal.getCaretaker().equals(caretaker)) {
                animal = currentAnimal;
                return animal;
            }
        }

        return animal;
    }

    public Animal getOldestAnimal() {
        return this.data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append("\n");

        this.data.forEach(a -> sb.append(a.getName()).append(" ").append(a.getCaretaker()).append("\n"));

        return sb.toString().trim();
    }
}
