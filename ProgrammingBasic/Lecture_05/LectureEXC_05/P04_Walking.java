package Lecture_05.LectureEXC_05;

import java.util.Scanner;

public class P04_Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int totalSteps = 0;

        while (!input.equals("Going home")) {
            int currentSteps = Integer.parseInt(input);
            totalSteps += currentSteps;

            if (totalSteps >= 10000) {
                break;
            }
            input = scanner.nextLine();
        }

        if (input.equals("Going home")) {
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            totalSteps += stepsToHome;
        }

        if (totalSteps < 10000) {
            System.out.printf("%d more steps to reach goal.", 10000 - totalSteps);
        } else {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", totalSteps - 10000);
        }
    }
}
