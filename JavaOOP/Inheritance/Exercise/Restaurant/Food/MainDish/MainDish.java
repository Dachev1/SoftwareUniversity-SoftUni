package Inheritance.Exercise.Restaurant.Food.MainDish;

import Inheritance.Exercise.Restaurant.Food.Food;

import java.math.BigDecimal;

public class MainDish extends Food {
    public MainDish(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}
