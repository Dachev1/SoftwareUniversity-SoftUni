package MoreExercises_01;

import java.util.Scanner;

public class P04_VegetableMarket {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double vegetablesKg = Double.parseDouble(scanner.nextLine());
        double fruitsKg = Double.parseDouble(scanner.nextLine());
        int totalKgVegetables = Integer.parseInt(scanner.nextLine());
        int totalKgFruits = Integer.parseInt(scanner.nextLine());

        double priceForVegetables = vegetablesKg * totalKgVegetables;
        double priceForFruits = fruitsKg * totalKgFruits;

        double totalPrice = priceForVegetables + priceForFruits;
        double priceInEuro = totalPrice / 1.94;

        System.out.printf("%.2f",priceInEuro);
    }
}
