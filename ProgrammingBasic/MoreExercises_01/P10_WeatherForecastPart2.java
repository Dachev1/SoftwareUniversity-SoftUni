package MoreExercises_01;

import java.util.Scanner;

public class P10_WeatherForecastPart2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double degrees = Double.parseDouble(scanner.nextLine());

        if (degrees < 5)  {
            System.out.println("unknown");
        } else if (degrees <= 11.9) {
            System.out.println("Cold");
        } else  if (degrees <= 14.9) {
            System.out.println("Cool");
        } else  if (degrees <= 20) {
            System.out.println("Mild");
        } else if (degrees < 25.9) {
            System.out.println("Warm");
        } else if (degrees <= 35) {
            System.out.println("Hot");
        } else  {
            System.out.println("unknown");
        }
    }
}

