package interfaces_and_abstraction.exercise.military_elite.Spy;

import interfaces_and_abstraction.exercise.military_elite.Soldier.SoldierImpl;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d", getFirstName(), getLastName(), getId())).append(System.lineSeparator());
        stringBuilder.append(String.format("Code Number: %s", codeNumber));
        return stringBuilder.toString().trim();
    }
}
