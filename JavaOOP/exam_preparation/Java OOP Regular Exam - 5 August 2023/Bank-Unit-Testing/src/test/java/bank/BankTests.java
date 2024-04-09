package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTests {
    private static final String EXPECTED_NAME = "UniCredit";
    private static final int EXPECTED_CAPACITY = 5;
    private static final String DEFAULT_NAME = "UniCredit";
    private static final int DEFAULT_CAPACITY = 5;
    private Bank bank;
    private Client client1;
    private Client client2;
    @Before
    public void setUp() {
        bank = new Bank(DEFAULT_NAME, DEFAULT_CAPACITY);
        client1 = new Client("Ivan");
        client2 = new Client("Qvor");
    }

    @Test
    public void test_Constructor_Should_Create_Correct_Object() {
        String actualName = bank.getName();
        int actualCapacity = bank.getCapacity();

        Assert.assertEquals(EXPECTED_NAME, actualName);
        Assert.assertEquals(EXPECTED_CAPACITY, actualCapacity);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_When_Name_Is_Null_Should_Throw_Exception() {
        bank = new Bank(null, DEFAULT_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_When_Name_Is_Empty_Should_Throw_Exception() {
        bank = new Bank("      ", DEFAULT_CAPACITY);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Constructor_When_Capacity_Is_Below_Zero_Should_Throw_Exception() {
        bank = new Bank(DEFAULT_NAME, -1);
    }

    @Test
    public void test_GetCapacity_Should_Return_The_Correct_Value() {
        Assert.assertEquals(EXPECTED_CAPACITY, this.bank.getCapacity());
    }

    @Test
    public void test_GetCount_Should_Return_The_Correct_Value() {
        this.bank.addClient(client1);

        Assert.assertEquals(1, this.bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddClient_Should_Throw_Exception_When_Size_Equal_Capacity() {
        bank = new Bank(DEFAULT_NAME, 1);
        this.bank.addClient(client1);
        this.bank.addClient(client2);
    }

    @Test
    public void test_AddClient_Should_Add_Correctly() {
        this.bank.addClient(client1);
        this.bank.addClient(client2);
        Assert.assertEquals(2, this.bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveClient_Should_Throw_Exception_When_Client_Doesnt_Exists() {
        this.bank.removeClient("Gosho");
    }

    @Test
    public void test_RemoveClient_Should_Remove_Correctly() {
        this.bank.addClient(client1);
        this.bank.removeClient(client1.getName());
        Assert.assertEquals(0, this.bank.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_LoanWithdrawal_Should_Throw_Exception_When_Client_Doesnt_Exists() {
        this.bank.loanWithdrawal("Gosho");
    }

    @Test
    public void test_LoanWithdrawala_Should_Remove_Correctly() {
        this.bank.addClient(client1);
        this.bank.loanWithdrawal(client1.getName());

        Assert.assertFalse(client1.isApprovedForLoan());
    }

    @Test
    public void test_Statistics_Should_Return_Correct() {
        this.bank.addClient(client1);
        this.bank.addClient(client2);

        String actualStatistics = this.bank.statistics();
        Assert.assertEquals("The client Ivan, Qvor is at the UniCredit bank!", actualStatistics);
    }
}
