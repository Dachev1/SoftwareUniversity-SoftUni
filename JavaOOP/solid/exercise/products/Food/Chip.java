package solid.exercise.products.Food;

import solid.exercise.products.Product;

public class Chip extends BaseFood {
    public static final double CALORIES_PER_100_GRAMS = 529.0;

    public Chip(double grams) {
        super(grams, CALORIES_PER_100_GRAMS);
    }
}
