package ProgrammingFundamentals.Methods.Lab;

import java.util.Scanner;

public class P06_CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Integer.parseInt(scanner.nextLine());
        double height = Integer.parseInt(scanner.nextLine());

        System.out.println(String.format("%.0f", calculateRectangleArea(width, height)));
    }

    public static double calculateRectangleArea(double width, double height) {
        double area = 0;
        area = width * height;
        return area;
    }
}
