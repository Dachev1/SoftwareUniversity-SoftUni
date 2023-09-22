package MoreExercises_01;

import java.util.Scanner;

public class P02_TriangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double result = a * h / 2;

        System.out.println(String.format("%.2f", result));

    }
}
