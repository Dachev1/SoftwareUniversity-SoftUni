package interfaces_and_abstraction.exercise.military_elite.LieutenantGeneral;

import interfaces_and_abstraction.exercise.military_elite.Private.PrivateImpl;
import interfaces_and_abstraction.exercise.military_elite.Soldier.Soldier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Soldier> privatesList;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, Double salary) {

        super(id, firstName, lastName, salary);
        this.privatesList = new ArrayList<>();
    }

    public void addPrivate(Soldier soldier) {
        privatesList.add(soldier);
    }

    @Override
    public List<Soldier> getPrivates() {
        return Collections.unmodifiableList(privatesList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary())).append(System.lineSeparator());
        stringBuilder.append("Privates:").append(System.lineSeparator());
        for (Soldier soldier : privatesList) {
            stringBuilder.append(" ").append(soldier.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}