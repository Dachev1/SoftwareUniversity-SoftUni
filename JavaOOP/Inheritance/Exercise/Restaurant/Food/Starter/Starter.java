package Inheritance.Exercise.Restaurant.Food.Starter;

import Inheritance.Exercise.Restaurant.Food.Food;

import java.math.BigDecimal;

public class Starter extends Food {
    public Starter(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
