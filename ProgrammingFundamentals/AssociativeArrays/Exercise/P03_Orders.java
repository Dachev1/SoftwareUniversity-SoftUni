package ProgrammingFundamentals.AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> productsQuantity  = new LinkedHashMap<>();
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("buy")) {
                break;
            }

            String[] inputArgs = input.split(" ");

            String product = inputArgs[0];
            Double price = Double.parseDouble(inputArgs[1]);
            int quantity = Integer.parseInt(inputArgs[2]);

            productsPrice.put(product, price);

            if (!productsQuantity.containsKey(product)) {
                productsQuantity.put(product, quantity);
            } else {
                productsQuantity.put(product, productsQuantity.get(product) + quantity);
            }
        }

        for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {
            String productName= entry.getKey();
            double finalSum = entry.getValue() * productsQuantity.get(productName);
            System.out.printf("%s -> %.2f%n", productName, finalSum);
        }
    }
}
