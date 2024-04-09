package bank.entities.client.BranchBank;

import bank.entities.client.BaseClient;

public class Student extends BaseClient {
    private static final int INITIAL_INTERESTS_PERCENT = 2;

    public Student(String name, String ID, double income) {
        super(name, ID, INITIAL_INTERESTS_PERCENT, income);
    }

    @Override
    public void increase() {
        super.setInterest(super.getInterest() + 1);
    }
}
