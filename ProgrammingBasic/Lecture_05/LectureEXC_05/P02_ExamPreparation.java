package Lecture_05.LectureEXC_05;

import java.util.Scanner;

public class P02_ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int failedThreshold = Integer.parseInt(scanner.nextLine());

        int failedTimes = 0;
        int solvedProblemsCount = 0;
        double gradeSum = 0;
        String lastProblem = "";
        boolean isFailde = true;

        while (failedTimes < failedThreshold) {
            String problemName = scanner.nextLine();
            if ("Enough".equals(problemName)) {
                isFailde = false;
                break;
            }
            int grade = Integer.parseInt(scanner.nextLine());
            if (grade <= 4) {
                failedTimes++;
            }
            gradeSum += grade;
            solvedProblemsCount++;
            lastProblem = problemName;
        }
        if (isFailde) {
            System.out.printf("You need a break, %d poor grades.", failedThreshold);
        } else {
            System.out.printf("Average score: %.2f%n", gradeSum / solvedProblemsCount);
            System.out.printf("Number of problems: %d%n", solvedProblemsCount);
            System.out.printf("Last problem: %s", lastProblem);
        }
    }
}
