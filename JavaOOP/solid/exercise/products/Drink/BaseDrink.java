package solid.exercise.products.Drink;

import solid.exercise.products.Product;

public abstract class BaseDrink implements Drink {
    private double milliliters;
    private double density;
    private double caloriesPer100Grams;

    public BaseDrink(double milliliters, double density, double caloriesPer100Grams) {
        this.milliliters = milliliters;
        this.density = density;
        this.caloriesPer100Grams = caloriesPer100Grams;
    }

    @Override
    public double getDensity() {
        return this.density;
    }

    @Override
    public double getCalories() {
        return (this.caloriesPer100Grams / 100) * (this.milliliters * this.density);
    }

    @Override
    public double getLiters() {
        return this.milliliters / 1000;
    }
}
