package MoreExercises_02;

import java.util.Scanner;

public class P05_Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int food = Integer.parseInt(scanner.nextLine());
        double foodPerDayDog = Double.parseDouble(scanner.nextLine());
        double foodPerDayCat = Double.parseDouble(scanner.nextLine());
        double foodPerDayTurtle = Double.parseDouble(scanner.nextLine());

        double neededFood = days * (foodPerDayDog + foodPerDayCat + (foodPerDayTurtle / 1000));

        double diff = Math.abs(food - neededFood);
        if (neededFood >= food) {
            System.out.printf("%.0f kilos of food left.", Math.ceil(diff));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.floor(diff));
        }
    }
}
