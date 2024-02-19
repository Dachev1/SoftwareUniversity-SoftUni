package Exam.ChasingSharks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }
    public void addShark(Shark shark) {
        if (this.sharks.size() < this.capacity) {
            this.sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind) {
        for (Shark shark : this.sharks) {
            if (shark.getKind().equals(kind)) {
                this.sharks.remove(shark);
                return true;
            }
        }

        return false;
    }
    public Shark getLargestShark() {
        return sharks.stream().max(Comparator.comparing(Shark::getLength)).orElse(null);
    }
    public Shark getShark(String kind) {
        Shark shark = null;

        for (Shark currentShark : this.sharks) {
            if (currentShark.getKind().equals(kind)) {
                shark = currentShark;
                break;
            }
        }

        return shark;
    }

    public int getCount() {
        return this.sharks.size();
    }

    public int getAverageLength() {
        int avgLength = 0;

        for (Shark shark : this.sharks) {
            avgLength += shark.getLength();
        }

        return avgLength / this.sharks.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Sharks in %s:", this.name));
        sb.append(System.lineSeparator());

        for (Shark shark : this.sharks) {
            sb.append(String.format("The %s is %d centimeters long, eats %s and inhabits %s.",
                    shark.getKind(), shark.getLength(), shark.getFood(), shark.getHabitation()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
