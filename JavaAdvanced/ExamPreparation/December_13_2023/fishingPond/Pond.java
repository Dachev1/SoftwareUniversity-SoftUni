package ExamPreparation.December_13_2023.fishingPond;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pond {

    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (fishes.size() < capacity) {
            fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        Fish fish = this.getFish(species);
        fishes.remove(fish);
        return fish != null;
    }

    public Fish getOldestFish() {
        return fishes.stream().max(Comparator.comparing(Fish::getAge)).orElse(null);
    }

    public Fish getFish(String species) {
        return fishes.stream().filter(f -> f.getSpecies().equals(species)).findFirst().orElse(null);
    }
    public int getCount(){
        return fishes.size();
    }

    public int getVacancies() {
        return capacity - getCount();}

    public String report(){
        StringBuilder build = new StringBuilder();
        build.append("Fishes in the pond:");
        build.append(System.lineSeparator());
        fishes.forEach(fish -> build.append(fish.toString()).append(String.format(System.lineSeparator())));

        return build.toString().trim();
    }
}
