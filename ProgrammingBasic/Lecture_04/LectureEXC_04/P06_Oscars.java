package Lecture_04.LectureEXC_04;

import java.util.Scanner;

public class P06_Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int examiners = Integer.parseInt(scanner.nextLine());

        double totalPoints = academyPoints;

        for (int i = 1; i <= examiners; i++) {
            String examiner = scanner.nextLine();
            double examinerPoints = Double.parseDouble(scanner.nextLine());

            totalPoints += (examiner.length() * examinerPoints) / 2;

            if (totalPoints >= 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, totalPoints);
                break;
            }
        }

        if (totalPoints < 1250.5) {
            double diff = Math.abs(totalPoints - 1250.5);
            System.out.printf("Sorry, %s you need %.1f more!", actorName, diff);
        }
    }
}
