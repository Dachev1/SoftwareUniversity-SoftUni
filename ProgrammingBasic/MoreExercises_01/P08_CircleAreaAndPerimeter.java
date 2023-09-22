package MoreExercises_01;

import java.util.Scanner;

public class P08_CircleAreaAndPerimeter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());

        double calculatedArea = Math.PI * r * r;
        double calculatedParameter = 2 * Math.PI * r ;

        System.out.printf("%.2f" + "\n" + "%.2f", calculatedArea, calculatedParameter);
    }
}
