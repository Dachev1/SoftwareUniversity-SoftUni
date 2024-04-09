package Inheritance.Exercise.Restaurant.Beverage.ColdBeverage;

import Inheritance.Exercise.Restaurant.Beverage.Beverage;

import java.math.BigDecimal;

public class ColdBeverage extends Beverage {
    public ColdBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
