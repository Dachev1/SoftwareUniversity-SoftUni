package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {
    // Service
    private static final String INITIAL_SERVICE_NAME = "Ajax";
    private static final int INITIAL_SERVICE_CAPACITY = 1;
    // Robot
    private static final String INITIAL_ROBOT_NAME = "Ivan";
    // Const
    private static final String INVALID_NAME = "Kris";
    private static final String EXPECTED_OUTPUT = "The robot Ivan is in the service Ajax!";
    private static final int WRONG_CAPACITY = -1;
    private static final int EXPECTED_COUNT = 1;
    private static final int ZERO = 0;

    private Service service;
    private Robot robot;

    @Before
    public void setUp() {
        this.service = new Service(INITIAL_SERVICE_NAME, INITIAL_SERVICE_CAPACITY);
        this.robot = new Robot(INITIAL_ROBOT_NAME);
        this.service.add(this.robot);
    }

    @Test
    public void test_Constructor_Should_Create_Correct_Object() {
        String actualName = this.service.getName();
        int actualCapacity = this.service.getCapacity();

        Assert.assertEquals(INITIAL_SERVICE_NAME, actualName);
        Assert.assertEquals(INITIAL_SERVICE_CAPACITY, actualCapacity);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_Should_Throw_Exception_When_Name_Is_Null() {
        this.service = new Service(null, INITIAL_SERVICE_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void test_Constructor_Should_Throw_Exception_When_Name_Is_Empty() {
        this.service = new Service("   ", INITIAL_SERVICE_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_Should_Throw_Exception_When_Capacity_Is_Below_Zero() {
        this.service = new Service(INITIAL_SERVICE_NAME, WRONG_CAPACITY);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_add_Should_Throw_Exception_When_Size_Equal_Capacity() {
        this.service.add(this.robot);
    }

    @Test
    public void test_getCapacity_Should_Return_Correct_Value() {
        int actualCapacity = this.service.getCapacity();

        Assert.assertEquals(actualCapacity, INITIAL_SERVICE_CAPACITY);
    }

    @Test
    public void test_getCount_Should_Return_Correct_Value() {
        Assert.assertEquals(this.service.getCount(), EXPECTED_COUNT);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_remove_When_Name_Is_Null_Should_Throw_Exception() {
        this.service.remove(INVALID_NAME);
    }

    @Test
    public void test_remove_Should_Remove_Correctly() {
        this.service.remove(INITIAL_ROBOT_NAME);
        Assert.assertEquals(ZERO, this.service.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_forSale_When_Name_Is_Null_Should_Throw_Exception() {
        this.service.forSale(INVALID_NAME);
    }

    @Test
    public void test_forSale_Should_Change_ReadyForSale_Correctly() {
        this.service.forSale(INITIAL_ROBOT_NAME);
        Assert.assertFalse(this.robot.isReadyForSale());
    }

    @Test
    public void test_report_Should_Return_Correct_Output() {
        String actualOutput = this.service.report();
        Assert.assertEquals(EXPECTED_OUTPUT, actualOutput);
    }
}
