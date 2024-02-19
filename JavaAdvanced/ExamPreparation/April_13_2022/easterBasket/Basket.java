package ExamPreparation.April_13_2022.easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;

    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                this.data.remove(egg);
                return true;
            }
        }

        return false;
    }

    public Egg getStrongestEgg() {
        return this.data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        Egg egg = null;

        for (Egg eg : this.data) {
            if (eg.getColor().equals(color)) {
                egg = eg;
                break;
            }
        }

        return egg;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s basket contains:", this.material));
        builder.append(System.lineSeparator());

        for (Egg egg : this.data) {
            builder.append(egg);
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
