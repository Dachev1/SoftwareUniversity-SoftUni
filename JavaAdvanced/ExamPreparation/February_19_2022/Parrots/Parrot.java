package ExamPreparation.February_19_2022.Parrots;

public class Parrot {
    private String name;
    private String species;
    private boolean available = true;

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isAvailable() {
        return this.available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s", this.species, this.name);
    }
}
