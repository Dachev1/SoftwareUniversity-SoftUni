package EXAM;

import java.util.Scanner;

public class P04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());

        int group1 = 0;
        int group2 = 0;
        int group3 = 0;
        int group4 = 0;
        double averageGrade = 0;

        for (double i = 1; i <= studentsCount ; i++) {
            double currentGrade = Double.parseDouble(scanner.nextLine());
            averageGrade += currentGrade;

            if (currentGrade >= 5.00) {
                group1++;
            } else if (currentGrade >= 4.00) {
                group2++;
            } else if (currentGrade >= 3) {
                group3++;
            } else {
                group4++;
            }
        }

        double group1Percent = (group1 * 1.0 / studentsCount) * 100;
        double group2Percent = (group2 * 1.0 / studentsCount) * 100;
        double group3Percent = (group3 * 1.0 / studentsCount) * 100;
        double group4Percent = (group4 * 1.0 / studentsCount) * 100;
        averageGrade /= studentsCount;


        System.out.printf("Top students: %.2f%%%n", group1Percent);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", group2Percent);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", group3Percent);
        System.out.printf("Fail: %.2f%%%n", group4Percent);
        System.out.printf("Average: %.2f", averageGrade);


    }
}