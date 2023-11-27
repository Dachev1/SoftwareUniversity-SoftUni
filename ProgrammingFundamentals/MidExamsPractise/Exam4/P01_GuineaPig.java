package ProgrammingFundamentals.MidExamsPractise.Exam4;

import java.util.Scanner;

public class P01_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodInKg = Double.parseDouble(scanner.nextLine());
        double hayInKg = Double.parseDouble(scanner.nextLine());
        double coverInKg = Double.parseDouble(scanner.nextLine());
        double pigWeightInKg = Double.parseDouble(scanner.nextLine());

        double foodInGrams = foodInKg * 1000;
        double hayInGrams = hayInKg * 1000;
        double coverInGrams = coverInKg * 1000;
        double pigWeightInGrams = pigWeightInKg * 1000;

        for (int day = 1; day <= 30; day++) {
                foodInGrams -= 300;

            if (day % 2 == 0) {
                hayInGrams -= 0.05 * foodInGrams;
            }

            if (day % 3 == 0) {
                coverInGrams -= pigWeightInGrams / 3;
            }

            if (foodInGrams <= 0 || hayInGrams <= 0 || coverInGrams <= 0) {
                System.out.println("Merry must go to the pet store!");
                return;
            }
        }

        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                          foodInGrams / 1000, hayInGrams / 1000, coverInGrams / 1000);

    }
}
