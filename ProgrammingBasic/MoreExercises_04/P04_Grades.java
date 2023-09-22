package MoreExercises_04;

import java.util.Scanner;

public class P04_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        int moreThan5  = 0;
        int moreThan4 = 0;
        int moreThan3 = 0;
        int lessThan3 = 0;
        double averageResult = 0;

        for (int i = 1; i <= students; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            averageResult += grade;

            if (grade < 3) {
                lessThan3++;
            } else if (grade <= 3.99) {
                moreThan3++;
            } else if (grade <= 4.99) {
                moreThan4++;
            } else {
                moreThan5 ++;
            }
        }

        double topStudents = (moreThan5  * 1.0 / students) * 100;
        double fourStudents = (moreThan4 * 1.0 / students) * 100;
        double threeStudents  = (moreThan3 * 1.0 / students) * 100;
        double twoStudents  = (lessThan3 * 1.0 / students) * 100;


        System.out.printf("Top students: %.2f%%%n", topStudents );
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", fourStudents );
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", threeStudents );
        System.out.printf("Fail: %.2f%%%n", twoStudents );
        System.out.printf("Average: %.2f%n", averageResult / students);
    }
}
