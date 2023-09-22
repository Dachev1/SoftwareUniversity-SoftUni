package ProgrammingBasicsOnlineExam9And10March2019;

import java.util.Scanner;

public class P03_Gymnastics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();
        String device = scanner.nextLine();

        double difficultyPoints = 0;
        double executionPoints = 0;

        if (country.equals("Russia")) {
            if (device.equals("ribbon")) {
                difficultyPoints = 9.100;
                executionPoints = 9.400;
            } else if (device.equals("hoop")) {
                difficultyPoints = 9.300;
                executionPoints = 9.800;
            } else if (device.equals("rope")) {
                difficultyPoints = 9.600;
                executionPoints = 9.000;
            }
        } else if (country.equals("Bulgaria")) {
            if (device.equals("ribbon")) {
                difficultyPoints = 9.600;
                executionPoints = 9.400;
            } else if (device.equals("hoop")) {
                difficultyPoints = 9.550;
                executionPoints = 9.750;
            } else if (device.equals("rope")) {
                difficultyPoints = 9.500;
                executionPoints = 9.400;
            }
        } else if (country.equals("Italy")) {
            if (device.equals("ribbon")) {
                difficultyPoints = 9.200;
                executionPoints = 9.500;
            } else if (device.equals("hoop")) {
                difficultyPoints = 9.450;
                executionPoints = 9.350;
            } else if (device.equals("rope")) {
                difficultyPoints = 9.700;
                executionPoints = 9.150;
            }
        }

        double grade = difficultyPoints + executionPoints;
        double neededPercentForMaxPoints = (Math.abs(grade - 20) / 20) * 100;

        System.out.printf("The team of %s get %.3f on %s.%n", country, grade, device);
        System.out.printf("%.2f%%", neededPercentForMaxPoints);
    }
}
