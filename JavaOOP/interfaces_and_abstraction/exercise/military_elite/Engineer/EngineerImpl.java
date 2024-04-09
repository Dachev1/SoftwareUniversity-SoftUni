package interfaces_and_abstraction.exercise.military_elite.Engineer;

import interfaces_and_abstraction.exercise.military_elite.Repair.Repair;
import interfaces_and_abstraction.exercise.military_elite.SpecialisedSoldier.SpecialisedSoldierImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(repairs);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary())).append(System.lineSeparator());
        stringBuilder.append("Corps: ").append(getCorp()).append(System.lineSeparator());
        stringBuilder.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : repairs) {
            stringBuilder.append(" ").append(repair.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}