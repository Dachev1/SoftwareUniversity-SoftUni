package DefiningClasses.Lab.Bank;

public class BankAccount {

    private final static double DEFAULT_INTEREST_RATE = 0.02d;
    private static int BankAccountCount = 1;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private int id;
    private double balance;


    public BankAccount() {
        this.id = BankAccount.BankAccountCount++;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
