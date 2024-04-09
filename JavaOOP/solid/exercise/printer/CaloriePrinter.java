package solid.exercise.printer;

import solid.exercise.calculators.Calculator;
import solid.exercise.calculators.CalorieCalculatorImpl;
import solid.exercise.products.Product;

import java.util.List;

public class CaloriePrinter {

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    private Calculator calculator;

    public CaloriePrinter(CalorieCalculatorImpl calorieCalculator) {
        this.calculator = calorieCalculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", this.calculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", this.calculator.average(products));
    }
}
