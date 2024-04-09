package solid.exercise.calculators;

import solid.exercise.products.Product;

import java.util.List;

public class CalorieCalculatorImpl implements Calculator {
    public CalorieCalculatorImpl() {
    }

    @Override
    public double sum(List<Product> products) {
        return products.stream().mapToDouble(Product::getCalories).sum();
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
