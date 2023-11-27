package ProgrammingFundamentals.Methods.Exercise.MoreExercises;

import java.util.Scanner;

public class P02_CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());

        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        PrintsClosestToTheCenterPoints(x1, y1, x2, y2);
    }
    static void PrintsClosestToTheCenterPoints(double x1, double y1, double x2, double y2)
    {
        double result = Math.abs(x1) + Math.abs(y1);
        double result2 = Math.abs(x2) + Math.abs(y2);

        if (result < result2)
        {
            System.out.printf("(%.0f, %.0f)", x1, y1);
        }
        else
        {
            System.out.printf("(%.0f, %.0f)", x2, y2);
        }
    }
}

