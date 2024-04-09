package busyWaiters;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

public class RestaurantTests {
    private static final String WAITER_INITIAL_NAME = "Ivan";
    private static final int WAITER_INITIAL_CAPACITY = 10;
    private static final String RESTAURANT_INITIAL_NAME = "UnoPio";
    private static final int RESTAURANT_INITIAL_CAPACITY = 3;
    private static final String NAME_IS_NULL = null;
    private static final String NAME_IS_EMPTY = " ";
    private static final int INVALID_CAPACITY = -1;
    private static final int EXPECTED_COUNT = 1;
    private static final int EXPECTED_SIZE = 3;
    private FullTimeWaiter waiter;
    private Restaurant restaurant;

    @Before
    public void setUp() {
        this.waiter = new FullTimeWaiter(WAITER_INITIAL_NAME, WAITER_INITIAL_CAPACITY);
        this.restaurant = new Restaurant(RESTAURANT_INITIAL_NAME, RESTAURANT_INITIAL_CAPACITY);
    }

    @Test
    public void test_Constructor_Should_Create_Correct_Object() {
        String actualName = this.restaurant.getName();
        int actualCapacity = this.restaurant.getCapacity();

        Assert.assertEquals(RESTAURANT_INITIAL_NAME, actualName);
        Assert.assertEquals(RESTAURANT_INITIAL_CAPACITY, actualCapacity);
    }

    @Test
    public void test_GetWaiters_Should_Return_All_Waiters() {
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("Kris", 12);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("Tombata", 10);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("Ivo", 1);

        this.restaurant.addFullTimeWaiter(fullTimeWaiter1);
        this.restaurant.addFullTimeWaiter(fullTimeWaiter2);
        this.restaurant.addFullTimeWaiter(fullTimeWaiter3);

        Collection<FullTimeWaiter> waiters = this.restaurant.getWaiters();
        Assert.assertEquals(EXPECTED_SIZE,waiters.size());
    }

    @Test (expected = NullPointerException.class)
    public void test_SetName_Should_Throw_When_Name_Is_Null() {
        this.restaurant = new Restaurant(NAME_IS_NULL, WAITER_INITIAL_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void test_SetName_Should_Throw_When_Name_Is_Empty() {
        this.restaurant = new Restaurant(NAME_IS_EMPTY, WAITER_INITIAL_CAPACITY);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_SetCapacity_Should_Throw_When_Capacity_Is_Negative() {
        this.restaurant = new Restaurant(RESTAURANT_INITIAL_NAME, INVALID_CAPACITY);
    }

    @Test
    public void test_GetCapacity_Should_Return_Correct_Capacity() {
        Assert.assertEquals(RESTAURANT_INITIAL_CAPACITY, this.restaurant.getCapacity());
    }

    @Test
    public void test_GetCount_Should_Return_Correct_Count() {
        this.restaurant.addFullTimeWaiter(this.waiter);
        Assert.assertEquals(EXPECTED_COUNT, this.restaurant.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_AddFullTimeWaiter_Should_Throw_When_Size_Of_Waiters_Equal_Capacity() {
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("Kris", 12);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("Tombata", 10);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("Ivo", 1);

        this.restaurant.addFullTimeWaiter(fullTimeWaiter1);
        this.restaurant.addFullTimeWaiter(fullTimeWaiter2);
        this.restaurant.addFullTimeWaiter(fullTimeWaiter3);
        this.restaurant.addFullTimeWaiter(this.waiter);

    }

    @Test (expected = IllegalArgumentException.class)
    public void test_AddFullTimeWaiter_Should_Throw_When_Waiter_Exist() {
        this.restaurant.addFullTimeWaiter(this.waiter);
        this.restaurant.addFullTimeWaiter(this.waiter);
    }

    @Test
    public void test_AddFullTimeWaiter_Should_Add() {
        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("Kris", 12);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("Tombata", 10);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("Ivo", 1);

        this.restaurant.addFullTimeWaiter(fullTimeWaiter1);
        this.restaurant.addFullTimeWaiter(fullTimeWaiter2);
        this.restaurant.addFullTimeWaiter(fullTimeWaiter3);
        Assert.assertEquals(3, this.restaurant.getCount());
    }

    @Test
    public void test_RemoveFullTimeWaiter_Should_Remove_True() {
       this.restaurant.addFullTimeWaiter(this.waiter);
       Assert.assertTrue(this.restaurant.removeFullTimeWaiter(this.waiter.getName()));
    }

    @Test
    public void test_RemoveFullTimeWaiter_Should_Remove_False() {
        Assert.assertFalse(this.restaurant.removeFullTimeWaiter(NAME_IS_NULL));
    }

}
