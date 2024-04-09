package bank.entities.loan;

public class StudentLoan extends BaseLoan{
    private static final int INTEREST_RATE = 1;
    private static final int AMOUNT = 10_000;

    public StudentLoan() {
        super(INTEREST_RATE, AMOUNT);
    }
}
