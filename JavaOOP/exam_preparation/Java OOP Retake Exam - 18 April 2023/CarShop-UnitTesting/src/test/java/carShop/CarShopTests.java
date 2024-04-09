package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarShopTests {

    private Car car;
    private CarShop shop;
    @Before
    public void setUp() {
        this.shop = new CarShop();
        this.car = new Car("Golf6",200, 1000);
        this.shop.add(car);
    }

    @Test
    public void test_getCount_Should_Give_Correct_Count() {
        Assert.assertEquals(1, this.shop.getCount());
    }

    @Test
    public void test_findAllCarsWithMaxHorsePower_Should_Return_Correct_Value() {
        List<Car> allCarsWithMaxHorsePower = this.shop.findAllCarsWithMaxHorsePower(199);
        Assert.assertEquals(List.of(this.car), allCarsWithMaxHorsePower);
    }

    @Test (expected = NullPointerException.class)
    public void test_add_Should_Throw_Exception_When_Car_Is_Null() {
        this.car = null;
        this.shop.add(this.car);
    }

    @Test
    public void test_add_Should_Add_Correctly() {
        this.car = new Car("Golf5",100, 1500);
        this.shop.add(this.car);
    }

    @Test
    public void test_remove_Should_Remove_Object() {
        Car car1 = new Car("Golf5",100, 1500);
        this.shop.add(car1);

        this.shop.remove(car1);
        Assert.assertEquals(1, this.shop.getCount());
    }

    @Test
    public void test_getTheMostLuxuryCar_Should_Give_The_Correct_Value() {
        Car car1 = new Car("Golf5",100, 100);
        this.shop.add(car1);

        Assert.assertEquals(this.car, this.shop.getTheMostLuxuryCar());
    }

    @Test
    public void test_findAllCarByModel_Should_Return_Correct_Values() {
        Car golf = new Car("Golf6",222, 1000);
        this.shop.add(golf);

        Assert.assertEquals(List.of(this.car, golf), this.shop.findAllCarByModel("Golf6"));
    }
}

