package MoreExercises_01;

import java.util.Scanner;

public class P07_HousePainting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

         double x = Double.parseDouble(scanner.nextLine());
         double y = Double.parseDouble(scanner.nextLine());
         double h = Double.parseDouble(scanner.nextLine());

         // Green
         double sideWall = x * y;
         double window = 1.5 * 1.5;
         double twoSideWalls = (2 * sideWall) - (2 * window);
         double backWall = x * x;
         double enterWall = 1.2 * 2;
         double FrontBackWall = (2 * backWall) - enterWall;
         double totalG = twoSideWalls + FrontBackWall;
         double greenPaint = totalG / 3.4;

         // Red
        double roofP1 = 2 * (x * y);
        double roofP2 = 2 * (x * h / 2);
        double totalR = roofP1 + roofP2;
        double redPaint = totalR / 4.3;

        System.out.printf("%.2f" + "\n" + "%.2f", greenPaint, redPaint);

    }
}


