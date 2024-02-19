package ExamPreparation.October_23_2021.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                this.roster.remove(person);
                return true;
            }
        }

        return false;
    }

    public Person getPerson(String name, String hometown) {
        Person person = null;

        for (Person p : this.roster) {
            if (p.getName().equals(name) && p.getHometown().equals(hometown)) {
                person = p;
                return person;
            }
        }

        return person;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The people in the hotel %s are:", this.name));
        sb.append(System.lineSeparator());

        for (Person person : this.roster) {
            sb.append(person);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
