package ExamPreparation.October_21_2023.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Kid> data;
    private int capacity;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addKid(Kid kid) {
        if (this.data.size() < this.capacity) {
            this.data.add(kid);
        }
    }
    public boolean removeKid(String name) {
        for (Kid kid: this.data) {
            if (kid.getName().equals(name)){
                this.data.remove(kid);
                return true;
            }
        }
        return false;
    }
    public Kid getKid(String city){
        for (Kid kid : this.data) {
            if (kid.getStreet().equals(city)) {
                return kid;
            }
        }
        return null;
    }
    public int getAllKids(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sB = new StringBuilder();
        sB.append("Children who visited a house for candy:").append(System.lineSeparator());
        for (Kid kid : this.data) {
            sB.append(String.format("%s from %s street", kid.getName(), kid.getStreet()))
                    .append(System.lineSeparator());
        }
        return sB.toString();
    }
}

