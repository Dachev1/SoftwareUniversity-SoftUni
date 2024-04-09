package bank.entities.loan;

public class MortgageLoan extends BaseLoan {
    private static final int INTEREST_RATE = 3;
    private static final int AMOUNT = 50_000;
    public MortgageLoan() {
        super(INTEREST_RATE, AMOUNT);
    }
}
