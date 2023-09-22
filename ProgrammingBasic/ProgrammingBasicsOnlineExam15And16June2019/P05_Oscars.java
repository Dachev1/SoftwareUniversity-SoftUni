package ProgrammingBasicsOnlineExam15And16June2019;

import java.util.Scanner;

public class P05_Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double pointsFromAcademy = Double.parseDouble(scanner.nextLine());
        int examiners = Integer.parseInt(scanner.nextLine());

        double totalPoint = pointsFromAcademy;

        for (int i = 1; i <= examiners ; i++) {
            String examinerName = scanner.nextLine();
            double currentPoints = Double.parseDouble(scanner.nextLine());

            totalPoint += (examinerName.length() * currentPoints) / 2;

            if (totalPoint >= 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, totalPoint);
                return;
            }
        }

            System.out.printf("Sorry, %s you need %.1f more!", actorName, Math.abs(totalPoint - 1250.5));
        }
    }
