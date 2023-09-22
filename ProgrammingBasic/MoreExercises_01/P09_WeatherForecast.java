package MoreExercises_01;

import java.util.Objects;
import java.util.Scanner;

public class P09_WeatherForecast {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String weather = scanner.nextLine();

        if (Objects.equals(weather, "sunny")) {
            System.out.println("It's warm outside!");
        } else if (Objects.equals(weather, "cloudy")) {
            System.out.println("It's cold outside!");
        } else {
            System.out.println("It's cold outside!");
        }
    }
}
