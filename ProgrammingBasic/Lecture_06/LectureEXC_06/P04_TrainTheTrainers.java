package Lecture_06.LectureEXC_06;

import java.util.Scanner;

public class P04_TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juryCount = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        double gradesPerPresentation = 0;
        double allGrades = 0;
        int allGradesCount = 0;

        while (!input.equals("Finish")) {
            for (double grades = 1; grades <= juryCount; grades++) {
                double currentGrade = Double.parseDouble(scanner.nextLine());
                allGrades += currentGrade;
                gradesPerPresentation += currentGrade / juryCount;
                allGradesCount++;
            }

            System.out.printf("%n%s - %.2f.", input, gradesPerPresentation);
            gradesPerPresentation = 0;

            input = scanner.nextLine();
        }


        System.out.printf("%nStudent's final assessment is %.2f.", allGrades / allGradesCount);
        }
}
