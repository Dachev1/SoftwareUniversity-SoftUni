package bank.entities.client.CentralBank;

import bank.entities.client.BaseClient;

public class Adult extends BaseClient {
    private static final int INITIAL_INTERESTS_PERCENT = 4;
    public Adult(String name, String ID, double income) {
        super(name, ID, INITIAL_INTERESTS_PERCENT, income);
    }

    @Override
    public void increase() {
        super.setInterest(super.getInterest() + 2);
    }
}
