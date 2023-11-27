package ProgrammingFundamentals.Methods.Exercise.MoreExercises;

import java.util.Scanner;

public class P03_LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());

        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());

        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        double line1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double line2= Math.sqrt((x3 - x4) * (x3 - x4) + (y3 - y4) * (y3 - y4));

        if (line1 >= line2) {
            boolean first = true;

            if (Math.sqrt(x1 * x1 + y1 * y1) > Math.sqrt(x2 * x2 + y2 * y2)) {
                first = false;
            }

            if (first) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)\n", x1, y1, x2, y2);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)\n", x2, y2, x1, y1);
            }
        } else {
            boolean fisrt = true;

            if (Math.sqrt(x3 * x3 + y3 * y3) > Math.sqrt(x4 * x4 + y4 * y4)) {
                fisrt = false;
            }

            if (fisrt) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)\n", x3, y3, x4, y4);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)\n", x4, y4, x3, y3);
            }
        }
    }
}

