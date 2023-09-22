package ProgrammingBasicsOnlineExam6And7July2019;

import java.util.Scanner;

public class P04_Renovation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int noPaintPercent = Integer.parseInt(scanner.nextLine());

        int totalSurface = height * width * 4;
        double wallsToPaint = Math.ceil(totalSurface - (noPaintPercent * totalSurface * 1.0 / 100));

        String input = scanner.nextLine();

        while (!input.equals("Tired!")) {
            int painting = Integer.parseInt(input);

            wallsToPaint -= painting;

            if (wallsToPaint < 0) {
                System.out.printf("All walls are painted and you have %.0f l paint left!", Math.abs(wallsToPaint));
                return;
            } else if (wallsToPaint == 0) {
                System.out.println("All walls are painted! Great job, Pesho!");
                return;
            }

            input = scanner.nextLine();
        }

            System.out.printf("%.0f quadratic m left.", Math.abs(wallsToPaint));
    }
}
