package solid.exercise.calculators;

import solid.exercise.products.Product;

import java.util.List;

public interface Calculator {
    double sum (List<Product> products);
    double average (List<Product> products);
}
