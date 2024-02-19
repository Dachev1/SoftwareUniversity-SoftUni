package ExamPreparation.February_18_2023.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.registry.size() < this.capacity) {
            this.registry.add(child);
            return true;
        }

        return false;
    }

    public boolean removeChild(String firstName) {
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                this.registry.remove(child);
                return true;
            }
        }

        return false;
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName){
        return registry.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    public String registryReport() {
        List<Child> sortedChildren = this.registry.stream()
                .sorted(Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append("Registered children in ").append(this.name).append(":");

        for (Child child : sortedChildren) {
            sb.append(System.lineSeparator()).append("--").append(System.lineSeparator());
            sb.append(child.toString());
        }

        return sb.toString().trim();
    }
}