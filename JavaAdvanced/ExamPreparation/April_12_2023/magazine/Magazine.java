package ExamPreparation.April_12_2023.magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < this.capacity) {
            data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        Cloth cloth = this.getCloth(color);
        data.remove(cloth);
        return cloth != null;
    }

    public Cloth getSmallestCloth() {
        return data.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);
    }

    public Cloth getCloth(String color) {
        return data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s ExamPreparation.April_12_2023.magazine contains:%n", type)).trimToSize();

        data.forEach(egg -> sb.append(egg.toString()).append(String.format("%n")));

        return sb.toString().trim();
    }
}
